package com.tencent.mobileqq.flock.share.action;

import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.wxapi.data.WXShareRsp;
import com.tencent.mobileqq.wxapi.listener.IWXShareHelperListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import y45.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0016\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J5\u0010\u000f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072#\u0010\u000e\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00040\tH\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\nH\u0002J \u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\nH\u0014J\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0015\u001a\u00020\u0014H\u0014\u00a2\u0006\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/flock/share/action/FlockShare2WeChatAction;", "Lcom/tencent/mobileqq/flock/share/action/FlockShareBaseAction;", "Ly45/n;", "shareInfo", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "url", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "Lkotlin/ParameterName;", "name", "result", "callback", "o", MimeHelper.IMAGE_SUBTYPE_BITMAP, "p", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "sheetItem", "Lcom/tencent/mobileqq/flock/share/e;", "shareParam", "g", DomainData.DOMAIN_NAME, "", "e", "(Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;)Ljava/lang/Integer;", "<init>", "()V", "a", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public class FlockShare2WeChatAction extends FlockShareBaseAction {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/flock/share/action/FlockShare2WeChatAction$a;", "", "", "IMAGE_SIZE", "I", "", "IMG_MAX_BYTES", "D", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.flock.share.action.FlockShare2WeChatAction$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/flock/share/action/FlockShare2WeChatAction$b", "Lcom/tencent/mobileqq/wxapi/listener/IWXShareHelperListener;", "Lcom/tencent/mobileqq/wxapi/data/WXShareRsp;", "resp", "", "onWXShareResp", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements IWXShareHelperListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.wxapi.listener.IWXShareHelperListener
        public void onWXShareResp(@NotNull WXShareRsp resp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) resp);
                return;
            }
            Intrinsics.checkNotNullParameter(resp, "resp");
            RFWLog.i("FlockShare2WeChatAction", RFWLog.USR, "onWXShareResp, errCode:" + resp.errCode + ", errStr:" + resp.errStr);
            int i3 = resp.errCode;
            com.tencent.mobileqq.flock.share.b bVar = com.tencent.mobileqq.flock.share.b.f210420a;
            if (i3 != bVar.b() && i3 != bVar.c()) {
                bVar.a();
            }
            com.tencent.mobileqq.flock.share.c.f210421a.d().removeObserver(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/flock/share/action/FlockShare2WeChatAction$c", "Lcom/tencent/libra/listener/IPicLoadStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "onStateChange", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c implements IPicLoadStateListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1<Bitmap, Unit> f210412d;

        /* JADX WARN: Multi-variable type inference failed */
        c(Function1<? super Bitmap, Unit> function1) {
            this.f210412d = function1;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function1);
            }
        }

        @Override // com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(@Nullable LoadState state, @Nullable Option option) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) state, (Object) option);
                return;
            }
            RFWLog.i("FlockShare2WeChatAction", RFWLog.USR, "downloadImg, state:" + state);
            boolean z17 = true;
            if (state != null && state.isFinishSuccess()) {
                z16 = true;
            } else {
                z16 = false;
            }
            Bitmap bitmap = null;
            if (z16) {
                Function1<Bitmap, Unit> function1 = this.f210412d;
                if (option != null) {
                    bitmap = option.getResultBitMap();
                }
                function1.invoke(bitmap);
                return;
            }
            if (state == null || !state.isFinishError()) {
                z17 = false;
            }
            if (z17) {
                this.f210412d.invoke(null);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49043);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public FlockShare2WeChatAction() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m() {
        com.tencent.mobileqq.flock.share.c.f210421a.d().addObserver(new b());
    }

    private final void o(String url, Function1<? super Bitmap, Unit> callback) {
        com.tencent.mobileqq.flock.picloader.a a16 = com.tencent.mobileqq.flock.picloader.a.a();
        Option obtain = Option.obtain();
        obtain.setRequestWidth(80);
        obtain.setRequestHeight(80);
        obtain.setUrl(url);
        a16.d(obtain, new c(callback));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap p(Bitmap bitmap) {
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            double d16 = width * height;
            if (d16 <= 8000.0d) {
                return bitmap;
            }
            double sqrt = Math.sqrt(8000.0d / d16);
            return Bitmap.createScaledBitmap(bitmap, (int) (width * sqrt), (int) (height * sqrt), true);
        } catch (Exception e16) {
            RFWLog.fatal("FlockShare2WeChatAction", RFWLog.USR, e16);
            return null;
        }
    }

    private final void q(final n shareInfo) {
        com.tencent.mobileqq.flock.share.c cVar = com.tencent.mobileqq.flock.share.c.f210421a;
        if (!cVar.e()) {
            h("\u9700\u8981\u5b89\u88c5\u5fae\u4fe1\u624d\u80fd\u8fdb\u884c\u5206\u4eab\u54e6");
        } else {
            if (!cVar.f()) {
                h("\u5fae\u4fe1\u7248\u672c\u592a\u4f4e\u5566\uff0c\u5148\u53bb\u5347\u7ea7\u518d\u5206\u4eab\u5427");
                return;
            }
            String str = shareInfo.f449444c.f449405c;
            Intrinsics.checkNotNullExpressionValue(str, "shareInfo.cover.picUrl");
            o(str, new Function1<Bitmap, Unit>(shareInfo) { // from class: com.tencent.mobileqq.flock.share.action.FlockShare2WeChatAction$share2WeChat$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ n $shareInfo;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$shareInfo = shareInfo;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) FlockShare2WeChatAction.this, (Object) shareInfo);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap) {
                    invoke2(bitmap);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Bitmap bitmap) {
                    Bitmap p16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) bitmap);
                        return;
                    }
                    RFWLog.i("FlockShare2WeChatAction", RFWLog.USR, "share2WeChat, downloadImg, ret:" + bitmap);
                    if (bitmap != null) {
                        p16 = FlockShare2WeChatAction.this.p(bitmap);
                        if (p16 != null) {
                            FlockShare2WeChatAction.this.m();
                            FlockShare2WeChatAction.this.n(this.$shareInfo, bitmap);
                            return;
                        } else {
                            FlockShareBaseAction.i(FlockShare2WeChatAction.this, null, 1, null);
                            return;
                        }
                    }
                    FlockShareBaseAction.i(FlockShare2WeChatAction.this, null, 1, null);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.flock.share.action.FlockShareBaseAction
    @Nullable
    protected Integer e(@NotNull ShareActionSheetBuilder.ActionSheetItem sheetItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) sheetItem);
        }
        Intrinsics.checkNotNullParameter(sheetItem, "sheetItem");
        return 3;
    }

    @Override // com.tencent.mobileqq.flock.share.action.FlockShareBaseAction
    public void g(@NotNull Activity activity, @NotNull ShareActionSheetBuilder.ActionSheetItem sheetItem, @NotNull com.tencent.mobileqq.flock.share.e shareParam) {
        Unit unit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, activity, sheetItem, shareParam);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(sheetItem, "sheetItem");
        Intrinsics.checkNotNullParameter(shareParam, "shareParam");
        n n3 = shareParam.n();
        if (n3 != null) {
            q(n3);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            FlockShareBaseAction.i(this, null, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(@NotNull n shareInfo, @NotNull Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) shareInfo, (Object) bitmap);
            return;
        }
        Intrinsics.checkNotNullParameter(shareInfo, "shareInfo");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        com.tencent.mobileqq.flock.share.c.f210421a.d().shareWebPageToWXFriend(String.valueOf(System.currentTimeMillis()), shareInfo.f449442a, bitmap, shareInfo.f449443b, shareInfo.f449445d);
    }
}
