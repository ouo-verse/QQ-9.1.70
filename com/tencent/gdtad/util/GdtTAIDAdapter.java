package com.tencent.gdtad.util;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.ad.tangram.device.AdTAID;
import com.tencent.ad.tangram.device.AdTAIDAdapter;
import com.tencent.ad.tangram.privacy.AdPrivacyPolicyManager;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.turingfd.sdk.xq.ITuringDID;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtTAIDAdapter implements AdTAIDAdapter {
    private static final String TAG = "GdtTAIDAdapter";
    private volatile boolean initialized = false;

    private static int getErrorCodeForAidTicket(@Nullable ITuringDID iTuringDID) {
        String str;
        int errorCodeForAidTicketAndTaidTicketEntity = getErrorCodeForAidTicketAndTaidTicketEntity(iTuringDID);
        if (errorCodeForAidTicketAndTaidTicketEntity == 0) {
            if (iTuringDID != null) {
                str = iTuringDID.getAIDTicket();
            } else {
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                return 10;
            }
        }
        return errorCodeForAidTicketAndTaidTicketEntity;
    }

    private static int getErrorCodeForAidTicketAndTaidTicketEntity(@Nullable ITuringDID iTuringDID) {
        if (iTuringDID == null) {
            return 1;
        }
        if (iTuringDID.getErrorCode() == 0) {
            return 0;
        }
        if (iTuringDID.getErrorCode() == -10001) {
            return 6;
        }
        if (iTuringDID.getErrorCode() == -10008) {
            return 8;
        }
        if (iTuringDID.getErrorCode() == -10009) {
            return 7;
        }
        if (iTuringDID.getErrorCode() == 10010) {
            return 5;
        }
        if (iTuringDID.getErrorCode() == -10011) {
            return 2;
        }
        if (iTuringDID.getErrorCode() != -10004 && iTuringDID.getErrorCode() != -10012 && iTuringDID.getErrorCode() != -21052 && iTuringDID.getErrorCode() != -22056) {
            if (iTuringDID.getErrorCode() != -30014) {
                return 1;
            }
            return 10;
        }
        return 3;
    }

    private static int getErrorCodeForTaidTicket(@Nullable ITuringDID iTuringDID) {
        String str;
        int errorCodeForAidTicketAndTaidTicketEntity = getErrorCodeForAidTicketAndTaidTicketEntity(iTuringDID);
        if (errorCodeForAidTicketAndTaidTicketEntity == 0) {
            if (iTuringDID != null) {
                str = iTuringDID.getTAIDTicket();
            } else {
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                return 1;
            }
        }
        return errorCodeForAidTicketAndTaidTicketEntity;
    }

    @Override // com.tencent.ad.tangram.device.AdTAIDAdapter
    @NonNull
    public AdTAID.Entity getEntity(Context context) {
        ITuringDID c16 = com.tencent.mobileqq.turingfd.c.a().c(true);
        AdTAID.Entity entity = new AdTAID.Entity();
        if (c16 == null) {
            return entity;
        }
        entity.aidTicket = c16.getAIDTicket();
        entity.taidTicket = c16.getTAIDTicket();
        entity.expiredTimeMillis = c16.getExpiredTimestamp();
        entity.originErrorCode = c16.getErrorCode();
        entity.errorCodeForAidTicket = getErrorCodeForAidTicket(c16);
        entity.errorCodeForTaidTicket = getErrorCodeForTaidTicket(c16);
        return entity;
    }

    @Override // com.tencent.ad.tangram.device.AdTAIDAdapter
    public void init(Context context) {
        if (!AdPrivacyPolicyManager.getInstance().isAllowed()) {
            GdtLog.e(TAG, "init not allowed");
            return;
        }
        if (this.initialized) {
            return;
        }
        synchronized (this) {
            if (this.initialized) {
                return;
            }
            this.initialized = true;
            AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.gdtad.util.GdtTAIDAdapter.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        com.tencent.mobileqq.turingfd.c.a().e();
                    } catch (Throwable th5) {
                        GdtLog.e(GdtTAIDAdapter.TAG, "[init]", th5);
                    }
                }
            }, 4);
        }
    }
}
