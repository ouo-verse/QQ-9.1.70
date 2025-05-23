package com.tencent.qqnt.aio.assistedchat.aiservice;

import android.app.Activity;
import android.content.DialogInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.assistedchat.adapter.IAssistedChatSwitchAdapterApi;
import com.tencent.qqnt.aio.assistedchat.model.AssistedChatSwitch;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "isChecked", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class AIServiceUtil$getAIServiceSettingConfig$2$1 extends Lambda implements Function1<Boolean, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Activity $activity;
    final /* synthetic */ d $config;
    final /* synthetic */ String $dtPageId;
    final /* synthetic */ Function1<com.tencent.mobileqq.widget.listitem.a<?>, Unit> $notifyChangedListener;
    final /* synthetic */ AssistedChatSwitch $switch;
    final /* synthetic */ IAssistedChatSwitchAdapterApi $switchApi;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIServiceUtil$getAIServiceSettingConfig$2$1(Activity activity, d dVar, Function1<? super com.tencent.mobileqq.widget.listitem.a<?>, Unit> function1, String str, IAssistedChatSwitchAdapterApi iAssistedChatSwitchAdapterApi, AssistedChatSwitch assistedChatSwitch) {
        super(1);
        this.$activity = activity;
        this.$config = dVar;
        this.$notifyChangedListener = function1;
        this.$dtPageId = str;
        this.$switchApi = iAssistedChatSwitchAdapterApi;
        this.$switch = assistedChatSwitch;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, activity, dVar, function1, str, iAssistedChatSwitchAdapterApi, assistedChatSwitch);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Activity activity, d config, Function1 notifyChangedListener, IAssistedChatSwitchAdapterApi switchApi, AssistedChatSwitch assistedChatSwitch, DialogInterface dialogInterface, int i3) {
        List listOf;
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(config, "$config");
        Intrinsics.checkNotNullParameter(notifyChangedListener, "$notifyChangedListener");
        Intrinsics.checkNotNullParameter(switchApi, "$switchApi");
        Intrinsics.checkNotNullParameter(assistedChatSwitch, "$switch");
        if (!AppNetConnInfo.isNetSupport()) {
            AIServiceUtil aIServiceUtil = AIServiceUtil.f349008a;
            String string = activity.getString(R.string.cib);
            Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.string.network_error)");
            aIServiceUtil.J(1, string);
            return;
        }
        config.R(false);
        notifyChangedListener.invoke(config);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(assistedChatSwitch);
        IAssistedChatSwitchAdapterApi.a.a(switchApi, listOf, 2, null, 4, null);
        AIServiceUtil aIServiceUtil2 = AIServiceUtil.f349008a;
        aIServiceUtil2.B();
        aIServiceUtil2.J(2, "\u5df2\u5173\u95ed");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke2(bool);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Boolean bool) {
        List listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bool);
            return;
        }
        if (!AppNetConnInfo.isNetSupport()) {
            AIServiceUtil aIServiceUtil = AIServiceUtil.f349008a;
            String string = this.$activity.getString(R.string.cib);
            Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.string.network_error)");
            aIServiceUtil.J(1, string);
            this.$config.R(!bool.booleanValue());
            this.$notifyChangedListener.invoke(this.$config);
            return;
        }
        if (!bool.booleanValue()) {
            this.$config.R(!bool.booleanValue());
            this.$notifyChangedListener.invoke(this.$config);
            AIServiceUtil aIServiceUtil2 = AIServiceUtil.f349008a;
            final Activity activity = this.$activity;
            String str = this.$dtPageId;
            final d dVar = this.$config;
            final Function1<com.tencent.mobileqq.widget.listitem.a<?>, Unit> function1 = this.$notifyChangedListener;
            final IAssistedChatSwitchAdapterApi iAssistedChatSwitchAdapterApi = this.$switchApi;
            final AssistedChatSwitch assistedChatSwitch = this.$switch;
            aIServiceUtil2.E(activity, str, new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.aio.assistedchat.aiservice.l
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    AIServiceUtil$getAIServiceSettingConfig$2$1.b(activity, dVar, function1, iAssistedChatSwitchAdapterApi, assistedChatSwitch, dialogInterface, i3);
                }
            });
            return;
        }
        IAssistedChatSwitchAdapterApi iAssistedChatSwitchAdapterApi2 = this.$switchApi;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(this.$switch);
        IAssistedChatSwitchAdapterApi.a.a(iAssistedChatSwitchAdapterApi2, listOf, 1, null, 4, null);
        AIServiceUtil.f349008a.J(2, "\u5df2\u5f00\u542f");
    }
}
