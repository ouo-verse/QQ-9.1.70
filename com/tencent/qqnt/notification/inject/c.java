package com.tencent.qqnt.notification.inject;

import android.text.SpannableStringBuilder;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstractElement;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/notification/inject/c;", "", "Lmqq/app/AppRuntime;", "appRuntime", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "msgRecord", "", "j", "nickName", DomainData.DOMAIN_NAME, "notification_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface c {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes24.dex */
    public static final class a {
        @NotNull
        public static String a(@NotNull c cVar, @NotNull String nickName) {
            Intrinsics.checkNotNullParameter(nickName, "nickName");
            return nickName;
        }

        @NotNull
        public static String b(@NotNull c cVar, @NotNull AppRuntime appRuntime, @NotNull RecentContactInfo msgRecord) {
            Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            ArrayList<MsgAbstractElement> arrayList = msgRecord.abstractContent;
            if (arrayList != null) {
                Iterator<T> it = arrayList.iterator();
                while (it.hasNext()) {
                    spannableStringBuilder.append((CharSequence) ((MsgAbstractElement) it.next()).content);
                }
            }
            String spannableStringBuilder2 = spannableStringBuilder.toString();
            Intrinsics.checkNotNullExpressionValue(spannableStringBuilder2, "content.toString()");
            return spannableStringBuilder2;
        }
    }

    @NotNull
    String j(@NotNull AppRuntime appRuntime, @NotNull RecentContactInfo msgRecord);

    @NotNull
    String n(@NotNull String nickName);
}
