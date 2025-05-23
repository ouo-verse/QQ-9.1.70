package com.tencent.mobileqq.troop.troopsetting.share.troopsetting;

import android.graphics.Bitmap;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.api.ITroopShareWxMiniProgramApi;
import com.tencent.mobileqq.troop.api.impl.TroopShareWxMiniProgramApiImpl;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001d\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/share/troopsetting/WeChatShareAction;", "Lcom/tencent/mobileqq/troop/troopsetting/share/a;", "Lcom/tencent/mobileqq/troop/troopsetting/share/b;", "shareContext", "", "i", "Landroid/graphics/Bitmap;", "faceBmp", DomainData.DOMAIN_NAME, "bmp", "l", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "(Lcom/tencent/mobileqq/troop/troopsetting/share/b;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "", "d", "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class WeChatShareAction extends com.tencent.mobileqq.troop.troopsetting.share.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/share/troopsetting/WeChatShareAction$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopsetting.share.troopsetting.WeChatShareAction$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61090);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public WeChatShareAction() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void i(com.tencent.mobileqq.troop.troopsetting.share.b shareContext) {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(shareContext.b()), null, null, new WeChatShareAction$doShareToWX$1(this, shareContext, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object j(com.tencent.mobileqq.troop.troopsetting.share.b bVar, Continuation<? super Bitmap> continuation) {
        WeChatShareAction$getTroopFaceBitmap$1 weChatShareAction$getTroopFaceBitmap$1;
        Object coroutine_suspended;
        int i3;
        Ref.ObjectRef objectRef;
        if (continuation instanceof WeChatShareAction$getTroopFaceBitmap$1) {
            weChatShareAction$getTroopFaceBitmap$1 = (WeChatShareAction$getTroopFaceBitmap$1) continuation;
            int i16 = weChatShareAction$getTroopFaceBitmap$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                weChatShareAction$getTroopFaceBitmap$1.label = i16 - Integer.MIN_VALUE;
                Object obj = weChatShareAction$getTroopFaceBitmap$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = weChatShareAction$getTroopFaceBitmap$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        objectRef = (Ref.ObjectRef) weChatShareAction$getTroopFaceBitmap$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    CoroutineDispatcher coroutineDispatcher = Dispatchers.getDefault();
                    WeChatShareAction$getTroopFaceBitmap$2 weChatShareAction$getTroopFaceBitmap$2 = new WeChatShareAction$getTroopFaceBitmap$2(bVar, objectRef2, null);
                    weChatShareAction$getTroopFaceBitmap$1.L$0 = objectRef2;
                    weChatShareAction$getTroopFaceBitmap$1.label = 1;
                    if (BuildersKt.withContext(coroutineDispatcher, weChatShareAction$getTroopFaceBitmap$2, weChatShareAction$getTroopFaceBitmap$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    objectRef = objectRef2;
                }
                return objectRef.element;
            }
        }
        weChatShareAction$getTroopFaceBitmap$1 = new WeChatShareAction$getTroopFaceBitmap$1(this, continuation);
        Object obj2 = weChatShareAction$getTroopFaceBitmap$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = weChatShareAction$getTroopFaceBitmap$1.label;
        if (i3 == 0) {
        }
        return objectRef.element;
    }

    private final void k(com.tencent.mobileqq.troop.troopsetting.share.b shareContext) {
        com.tencent.mobileqq.troop.troopshare.a f16 = shareContext.f();
        if (f16 == null) {
            return;
        }
        TroopInfoData h16 = shareContext.h();
        if (QLog.isDevelopLevel()) {
            QLog.i("WeChatShareAction", 1, "[shareMiniProgram] troopUin = " + h16.troopUin + " joinGroupToken = " + f16.f301558f + ", joinGroupAuthority = " + f16.f301559g + ", shareLink = " + f16.f301556d);
        }
    }

    private final void l(com.tencent.mobileqq.troop.troopsetting.share.b shareContext, Bitmap bmp) {
        String str;
        String str2;
        try {
            TroopInfoData h16 = shareContext.h();
            com.tencent.mobileqq.troop.troopshare.a f16 = shareContext.f();
            String str3 = null;
            if (f16 != null) {
                str = f16.f301558f;
            } else {
                str = null;
            }
            String encode = URLEncoder.encode(str, "UTF-8");
            com.tencent.mobileqq.troop.troopshare.a f17 = shareContext.f();
            if (f17 != null) {
                str2 = f17.f301559g;
            } else {
                str2 = null;
            }
            String encode2 = URLEncoder.encode(str2, "UTF-8");
            String str4 = "pagesShare/groupProfile/groupProfile?groupCode=" + h16.troopUin + "&token=" + encode + "&joinGroupAuth=" + encode2;
            WXShareHelper b06 = WXShareHelper.b0();
            String qqStr = HardCodeUtil.qqStr(R.string.f181213d6);
            com.tencent.mobileqq.troop.troopshare.a f18 = shareContext.f();
            if (f18 != null) {
                str3 = f18.f301556d;
            }
            b06.I0(str4, TroopShareWxMiniProgramApiImpl.QQ_MINI_PROGRAM_ID, bmp, qqStr, "", str3);
            k(shareContext);
        } catch (Exception e16) {
            QLog.e("WeChatShareAction", 1, "[shareMiniProgram] " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(com.tencent.mobileqq.troop.troopsetting.share.b shareContext, Bitmap faceBmp) {
        String str;
        String str2;
        String str3;
        String c16 = c(shareContext);
        if (c16 == null) {
            str = "";
        } else {
            str = c16;
        }
        String b16 = b(shareContext);
        if (b16 == null) {
            str2 = "";
        } else {
            str2 = b16;
        }
        WXShareHelper b06 = WXShareHelper.b0();
        String valueOf = String.valueOf(System.currentTimeMillis());
        com.tencent.mobileqq.troop.troopshare.a f16 = shareContext.f();
        if (f16 != null) {
            str3 = f16.f301556d;
        } else {
            str3 = null;
        }
        b06.K0(valueOf, str, faceBmp, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(com.tencent.mobileqq.troop.troopsetting.share.b shareContext, Bitmap faceBmp) {
        String str;
        String str2;
        String str3;
        String str4;
        String c16 = c(shareContext);
        if (c16 == null) {
            str = "";
        } else {
            str = c16;
        }
        String b16 = b(shareContext);
        if (b16 == null) {
            str2 = "";
        } else {
            str2 = b16;
        }
        if (!((ITroopShareWxMiniProgramApi) QRoute.api(ITroopShareWxMiniProgramApi.class)).enableShareAsMiniProgram()) {
            WXShareHelper b06 = WXShareHelper.b0();
            String valueOf = String.valueOf(System.currentTimeMillis());
            com.tencent.mobileqq.troop.troopshare.a f16 = shareContext.f();
            if (f16 != null) {
                str4 = f16.f301556d;
            } else {
                str4 = null;
            }
            b06.J0(valueOf, str, faceBmp, str2, str4);
            return;
        }
        Bitmap troopPreviewBitmap = ((ITroopShareWxMiniProgramApi) QRoute.api(ITroopShareWxMiniProgramApi.class)).getTroopPreviewBitmap(shareContext.b(), faceBmp, str, str2);
        if (troopPreviewBitmap == null) {
            WXShareHelper b07 = WXShareHelper.b0();
            String valueOf2 = String.valueOf(System.currentTimeMillis());
            com.tencent.mobileqq.troop.troopshare.a f17 = shareContext.f();
            if (f17 != null) {
                str3 = f17.f301556d;
            } else {
                str3 = null;
            }
            b07.J0(valueOf2, str, faceBmp, str2, str3);
            return;
        }
        l(shareContext, troopPreviewBitmap);
    }

    @Override // com.tencent.mobileqq.troop.troopsetting.share.a
    public void a(@NotNull com.tencent.mobileqq.troop.troopsetting.share.b shareContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) shareContext);
            return;
        }
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        if (e(shareContext)) {
            return;
        }
        i(shareContext);
    }

    @Override // com.tencent.mobileqq.troop.troopsetting.share.a
    @NotNull
    public List<String> d() {
        List<String> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"weixin", "weixincircle"});
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 2, (Object) this);
    }
}
