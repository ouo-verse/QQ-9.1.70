package kh;

import android.text.TextUtils;
import com.tencent.mobileqq.qzoneplayer.video.SafeUrlState;
import com.tencent.mobileqq.qzoneplayer.video.l;
import com.tencent.mobileqq.qzoneplayer.video.s;
import com.tencent.oskplayer.model.SegmentVideoInfo;
import com.tencent.oskplayer.proxy.HttpRetryLogic;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes38.dex */
public class d extends c {
    public d(com.qzone.reborn.feedx.video.b bVar) {
        super(bVar);
    }

    private void v() {
        ArrayList<SegmentVideoInfo.SegmentInfo> arrayList;
        if (TextUtils.isEmpty(this.f412344b.c())) {
            QLog.e("QZonePlayerExchangeUrlInterceptor" + this.f412343a.j(), 1, "exchangeUrlOperation  url == null");
            return;
        }
        HttpRetryLogic c16 = com.tencent.mobileqq.qzoneplayer.videosource.a.d().c(this.f412344b.c());
        if (c16 == null) {
            QLog.e("QZonePlayerExchangeUrlInterceptor" + this.f412343a.j(), 1, "[exchangeUrlOperation] no retry logic");
            return;
        }
        String retryUrl = c16.getRetryUrl(this.f412344b.c(), 0, 403, null);
        QLog.i("QZonePlayerExchangeUrlInterceptor" + this.f412343a.j(), 1, "[exchangeUrlOperation] retryUrl = " + retryUrl);
        if (TextUtils.isEmpty(retryUrl)) {
            l h16 = s.g().h(this.f412344b.c(), false);
            if (h16 != null && h16.f280001a == SafeUrlState.URL_STATE_SUCCESS && (arrayList = h16.f280002b) != null && arrayList.size() > 0 && h16.f280002b.get(0) != null && !TextUtils.isEmpty(h16.f280002b.get(0).url)) {
                retryUrl = h16.f280002b.get(0).url;
                QLog.i("QZonePlayerExchangeUrlInterceptor" + this.f412343a.j(), 1, "[exchangeUrlOperation] try again  | retryUrl = " + retryUrl + " | originUrl = " + this.f412344b.c());
            } else {
                QLog.e("QZonePlayerExchangeUrlInterceptor" + this.f412343a.j(), 1, "[exchangeUrlOperation] invalid retryUrl");
                return;
            }
        }
        this.f412344b.p(retryUrl);
        this.f412343a.K();
        this.f412343a.U(0);
    }

    @Override // kh.c
    public boolean e(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
        QLog.e("QZonePlayerExchangeUrlInterceptor_" + this.f412343a.j(), 1, "[onError]  | errorCode = " + i17);
        if (14020003 != i17 && 14020004 != i17 && 11022115 != i17 && 11022116 != i17) {
            return false;
        }
        v();
        return false;
    }
}
