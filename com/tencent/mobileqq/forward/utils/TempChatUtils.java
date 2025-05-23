package com.tencent.mobileqq.forward.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleKt;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ$\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/forward/utils/TempChatUtils;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", "mExtraData", "Lkotlin/Function0;", "", "callback", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class TempChatUtils {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final TempChatUtils f211074a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58187);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f211074a = new TempChatUtils();
        }
    }

    TempChatUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(@NotNull Activity activity, @NotNull Bundle mExtraData, @NotNull Function0<Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, activity, mExtraData, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(mExtraData, "mExtraData");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!(activity instanceof LifecycleOwner)) {
            QLog.d("TempChatUtils", 1, "prepareTempChat not LifecycleOwner");
            callback.invoke();
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList parcelableArrayList = mExtraData.getParcelableArrayList(AppConstants.Key.FORWARD_MULTI_TARGET);
        if (parcelableArrayList != null && (!parcelableArrayList.isEmpty())) {
            int i3 = 0;
            for (Object obj : parcelableArrayList) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                ResultRecord resultRecord = (ResultRecord) obj;
                if (com.tencent.qqnt.aio.interceptor.a.f351159a.a(com.tencent.nt.adapter.session.c.l(resultRecord.getUinType())) != null) {
                    Intent intent = new Intent();
                    intent.putExtras(mExtraData);
                    intent.putExtra("uin", resultRecord.uin);
                    intent.putExtra("uintype", resultRecord.getUinType());
                    intent.putExtra("troop_uin", resultRecord.groupUin);
                    intent.putExtra("uinname", resultRecord.name);
                    intent.putExtra("guild_id", resultRecord.guildId);
                    SessionInfo sessionInfo = ForwardUtils.n0(intent);
                    Intrinsics.checkNotNullExpressionValue(sessionInfo, "sessionInfo");
                    arrayList.add(sessionInfo);
                }
                i3 = i16;
            }
        } else {
            SessionInfo p06 = ForwardUtils.p0(mExtraData);
            Intrinsics.checkNotNullExpressionValue(p06, "sessionFromIntent(mExtraData)");
            if (com.tencent.qqnt.aio.interceptor.a.f351159a.a(com.tencent.nt.adapter.session.c.l(p06.f179555d)) != null) {
                arrayList.add(p06);
            }
        }
        if (arrayList.isEmpty()) {
            QLog.d("TempChatUtils", 1, "prepareTempChat tempChats empty");
            callback.invoke();
        } else {
            Lifecycle lifecycle = ((LifecycleOwner) activity).getLifecycle();
            Intrinsics.checkNotNullExpressionValue(lifecycle, "activity.lifecycle");
            BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(lifecycle), Dispatchers.getIO(), null, new TempChatUtils$prepareTempChat$2(arrayList, activity, callback, null), 2, null);
        }
    }
}
