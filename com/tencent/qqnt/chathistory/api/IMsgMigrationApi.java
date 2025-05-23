package com.tencent.qqnt.chathistory.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016JL\u0010\u0010\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u0007H&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/chathistory/api/IMsgMigrationApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/content/Context;", "context", "", "jumpToChatHistorySettingFragment", "triggerToMigration", "", "bigT", "", "entry", "result", "r1", "r2", "r3", "r4", "reportBigT", "chathistory_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IMsgMigrationApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class a {
        public static /* synthetic */ void a(IMsgMigrationApi iMsgMigrationApi, String str, int i3, int i16, String str2, String str3, String str4, String str5, int i17, Object obj) {
            int i18;
            String str6;
            String str7;
            String str8;
            if (obj == null) {
                int i19 = 0;
                if ((i17 & 2) != 0) {
                    i18 = 0;
                } else {
                    i18 = i3;
                }
                if ((i17 & 4) == 0) {
                    i19 = i16;
                }
                String str9 = "";
                if ((i17 & 8) != 0) {
                    str6 = "";
                } else {
                    str6 = str2;
                }
                if ((i17 & 16) != 0) {
                    str7 = "";
                } else {
                    str7 = str3;
                }
                if ((i17 & 32) != 0) {
                    str8 = "";
                } else {
                    str8 = str4;
                }
                if ((i17 & 64) == 0) {
                    str9 = str5;
                }
                iMsgMigrationApi.reportBigT(str, i18, i19, str6, str7, str8, str9);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportBigT");
        }
    }

    void jumpToChatHistorySettingFragment(@Nullable Context context);

    void reportBigT(@NotNull String bigT, int entry, int result, @NotNull String r16, @NotNull String r26, @NotNull String r36, @NotNull String r46);

    void triggerToMigration(@Nullable Context context);
}
