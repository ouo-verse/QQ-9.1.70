package b00;

import UserGrowth.stNewsRedDot;
import UserGrowth.stNotificationRedDot;
import UserGrowth.stRedDotRsp;
import UserGrowth.stSimpleMetaPerson;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.weishi.home.avatarzone.WSRedDotEvent;
import com.tencent.biz.pubaccount.weishi.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi.util.ba;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.view.RedDotBubblePopupWindow;
import com.tencent.biz.pubaccount.weishi.view.WSRoundedImageView;
import com.tencent.biz.pubaccount.weishi.view.e;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 >2\u00020\u00012\u00020\u0002:\u0001?B!\u0012\u0006\u00109\u001a\u00020\u0016\u0012\b\u0010;\u001a\u0004\u0018\u00010:\u0012\u0006\u0010%\u001a\u00020\"\u00a2\u0006\u0004\b<\u0010=J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J$\u0010\u000e\u001a\u00020\u00032\u001a\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\fH\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0014\u001a\u00020\u0003H\u0002J\b\u0010\u0015\u001a\u00020\u0003H\u0002J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0014J\b\u0010\u001c\u001a\u00020\u0003H\u0016J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010 \u001a\u00020\u0003H\u0016J\b\u0010!\u001a\u00020\u0003H\u0016R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00108\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u00107\u00a8\u0006@"}, d2 = {"Lb00/h;", "Lrz/b;", "Lb00/b;", "", "I", "M", "L", "LUserGrowth/stSimpleMetaPerson;", "person", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/util/ArrayList;", "LUserGrowth/stNotificationRedDot;", "Lkotlin/collections/ArrayList;", "notificationRedDot", "O", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/biz/pubaccount/weishi/view/e$d;", "E", "Lcom/tencent/biz/pubaccount/weishi/view/e$e;", "G", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "y", "Landroid/app/Activity;", "J", "", "K", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "j", "LUserGrowth/stRedDotRsp;", "rsp", "y6", "x6", "onPageDestroy", "Lcom/tencent/biz/pubaccount/weishi/home/a;", tl.h.F, "Lcom/tencent/biz/pubaccount/weishi/home/a;", "iwsHomePresenter", "Lb00/a;", "i", "Lb00/a;", "presenter", "Lcom/tencent/biz/pubaccount/weishi/view/RedDotBubblePopupWindow;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/biz/pubaccount/weishi/view/RedDotBubblePopupWindow;", "bubblePopupWindow", "Lcom/tencent/biz/pubaccount/weishi/view/WSRoundedImageView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/pubaccount/weishi/view/WSRoundedImageView;", "roundImageView", "Landroid/widget/ImageView;", "D", "Landroid/widget/ImageView;", "wsIvRedDot", "Lcom/tencent/biz/pubaccount/weishi/view/e;", "Lcom/tencent/biz/pubaccount/weishi/view/e;", "wsPopupMenuDialog", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/view/ViewStub;", "viewStub", "<init>", "(Landroid/app/Activity;Landroid/view/ViewStub;Lcom/tencent/biz/pubaccount/weishi/home/a;)V", UserInfo.SEX_FEMALE, "a", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class h extends rz.b implements b {

    /* renamed from: F, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private WSRoundedImageView roundImageView;

    /* renamed from: D, reason: from kotlin metadata */
    private ImageView wsIvRedDot;

    /* renamed from: E, reason: from kotlin metadata */
    private com.tencent.biz.pubaccount.weishi.view.e wsPopupMenuDialog;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.biz.pubaccount.weishi.home.a iwsHomePresenter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private a presenter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private RedDotBubblePopupWindow bubblePopupWindow;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007\u00a8\u0006\f"}, d2 = {"Lb00/h$a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/view/ViewStub;", "viewStub", "Lcom/tencent/biz/pubaccount/weishi/home/a;", "iwsHomePresenter", "Lrz/a;", "a", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: b00.h$a, reason: from kotlin metadata */
    /* loaded from: classes39.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final rz.a a(Activity activity, ViewStub viewStub, com.tencent.biz.pubaccount.weishi.home.a iwsHomePresenter) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(iwsHomePresenter, "iwsHomePresenter");
            return new h(activity, viewStub, iwsHomePresenter);
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Activity activity, ViewStub viewStub, com.tencent.biz.pubaccount.weishi.home.a iwsHomePresenter) {
        super(activity, viewStub);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(iwsHomePresenter, "iwsHomePresenter");
        this.iwsHomePresenter = iwsHomePresenter;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0023, code lost:
    
        if ((!r0.isEmpty()) != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void A() {
        boolean z16;
        WSPublicAccReport.getInstance().reportAvatarViewClick(K());
        y();
        a aVar = this.presenter;
        if ((aVar != null ? aVar.v() : null) != null) {
            z16 = true;
        }
        z16 = false;
        this.wsPopupMenuDialog = com.tencent.biz.pubaccount.weishi.view.e.b(J(), z16, E(), G());
        WSRoundedImageView wSRoundedImageView = this.roundImageView;
        int width = ((wSRoundedImageView != null ? wSRoundedImageView.getWidth() / 2 : 0) - (ViewUtils.dip2px(152.0f) / 2)) - ViewUtils.dip2px(7.0f);
        com.tencent.biz.pubaccount.weishi.view.e eVar = this.wsPopupMenuDialog;
        if (eVar != null) {
            eVar.showAsDropDown(this.roundImageView, width, ViewUtils.dip2px(9.0f));
        }
        ImageView imageView = this.wsIvRedDot;
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(8);
    }

    @JvmStatic
    public static final rz.a B(Activity activity, ViewStub viewStub, com.tencent.biz.pubaccount.weishi.home.a aVar) {
        return INSTANCE.a(activity, viewStub, aVar);
    }

    private final e.d E() {
        return new e.d() { // from class: b00.d
            @Override // com.tencent.biz.pubaccount.weishi.view.e.d
            public final void a(e.c cVar) {
                h.F(h.this, cVar);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(h this$0, e.c cVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (cVar == null) {
            return;
        }
        switch (cVar.f82459a) {
            case R.string.x8l /* 1929904185 */:
                WSPublicAccReport.getInstance().reportMenuItemClick("feedback", this$0.K());
                a aVar = this$0.presenter;
                if (aVar != null) {
                    Context context = this$0.o();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    aVar.K(context);
                    return;
                }
                return;
            case R.string.x8m /* 1929904186 */:
                WSPublicAccReport.getInstance().reportMenuItemClick("my_homepage", this$0.K());
                a aVar2 = this$0.presenter;
                if (aVar2 != null) {
                    Context context2 = this$0.o();
                    Intrinsics.checkNotNullExpressionValue(context2, "context");
                    aVar2.G(context2);
                    return;
                }
                return;
            case R.string.x8n /* 1929904187 */:
                WSPublicAccReport.getInstance().reportMenuItemClick("message_notification", this$0.K());
                this$0.z();
                a aVar3 = this$0.presenter;
                if (aVar3 != null) {
                    Context context3 = this$0.o();
                    Intrinsics.checkNotNullExpressionValue(context3, "context");
                    aVar3.D(context3, 602);
                    return;
                }
                return;
            case R.string.x8o /* 1929904188 */:
                cz.f.f392428a.j(this$0.o(), cz.d.f392425a.c(), this$0.K());
                return;
            case R.string.x8p /* 1929904189 */:
                WSPublicAccReport.getInstance().reportMenuItemClick("settings_entry", this$0.K());
                a aVar4 = this$0.presenter;
                if (aVar4 != null) {
                    aVar4.n0(this$0.o());
                    return;
                }
                return;
            default:
                return;
        }
    }

    private final e.InterfaceC0839e G() {
        return new e.InterfaceC0839e() { // from class: b00.f
            @Override // com.tencent.biz.pubaccount.weishi.view.e.InterfaceC0839e
            public final void onDismiss() {
                h.H();
            }
        };
    }

    private final void I() {
        i iVar = new i();
        this.presenter = iVar;
        iVar.attachView(this);
    }

    private final Activity J() {
        return this.f432974d;
    }

    private final String K() {
        return this.iwsHomePresenter.e();
    }

    private final void L() {
        a aVar = this.presenter;
        if (aVar != null) {
            aVar.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(h this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.A();
    }

    private final void O(ArrayList<stNotificationRedDot> notificationRedDot) {
        final Activity J = J();
        if (notificationRedDot != null && notificationRedDot.size() > 0 && J != null) {
            WSPublicAccReport.getInstance().reportMessageBubblePopupExposure(K());
            RedDotBubblePopupWindow redDotBubblePopupWindow = new RedDotBubblePopupWindow(J, new RedDotBubblePopupWindow.a() { // from class: b00.e
                @Override // com.tencent.biz.pubaccount.weishi.view.RedDotBubblePopupWindow.a
                public final void a() {
                    h.P(h.this, J);
                }
            });
            this.bubblePopupWindow = redDotBubblePopupWindow;
            redDotBubblePopupWindow.h(this.roundImageView, notificationRedDot);
            ImageView imageView = this.wsIvRedDot;
            if (imageView == null) {
                return;
            }
            imageView.setVisibility(0);
            return;
        }
        ImageView imageView2 = this.wsIvRedDot;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
        RedDotBubblePopupWindow redDotBubblePopupWindow2 = this.bubblePopupWindow;
        if (redDotBubblePopupWindow2 != null) {
            redDotBubblePopupWindow2.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(h this$0, Activity activity) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WSPublicAccReport.getInstance().reportMessageBubblePopupClick(this$0.K());
        this$0.z();
        a aVar = this$0.presenter;
        if (aVar != null) {
            aVar.D(activity, 601);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(h this$0, Drawable drawable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ba.A(this$0.roundImageView, drawable);
    }

    private final void y() {
        RedDotBubblePopupWindow redDotBubblePopupWindow = this.bubblePopupWindow;
        if (redDotBubblePopupWindow != null) {
            redDotBubblePopupWindow.f();
        }
        this.bubblePopupWindow = null;
        com.tencent.biz.pubaccount.weishi.view.e eVar = this.wsPopupMenuDialog;
        boolean z16 = false;
        if (eVar != null && eVar.isShowing()) {
            z16 = true;
        }
        if (z16) {
            com.tencent.biz.pubaccount.weishi.view.e eVar2 = this.wsPopupMenuDialog;
            if (eVar2 != null) {
                eVar2.dismiss();
            }
            this.wsPopupMenuDialog = null;
        }
    }

    private final void z() {
        a aVar = this.presenter;
        if (aVar != null) {
            aVar.A(null);
        }
        ImageView imageView = this.wsIvRedDot;
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(8);
    }

    @Override // rz.b, rz.a
    public void j() {
        super.j();
        I();
        M();
        L();
    }

    @Override // rz.b, rz.a
    public void onPageDestroy() {
        super.onPageDestroy();
        y();
    }

    @Override // rz.b
    protected int q() {
        return R.layout.f167383d12;
    }

    @Override // b00.b
    public void y6(stRedDotRsp rsp) {
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        stNewsRedDot newsRedDot = rsp.newsReddot;
        Q(rsp.user);
        O(rsp.notificationReddot);
        wz.b b16 = wz.b.b();
        Intrinsics.checkNotNullExpressionValue(newsRedDot, "newsRedDot");
        b16.a(new WSRedDotEvent(newsRedDot));
    }

    @Override // b00.b
    public void x6() {
        Q(null);
    }

    private final void M() {
        this.roundImageView = (WSRoundedImageView) m(R.id.p96);
        this.wsIvRedDot = (ImageView) m(R.id.p95);
        WSRoundedImageView wSRoundedImageView = this.roundImageView;
        if (wSRoundedImageView != null) {
            wSRoundedImageView.setOnClickListener(new View.OnClickListener() { // from class: b00.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    h.N(h.this, view);
                }
            });
        }
    }

    private final void Q(stSimpleMetaPerson person) {
        Drawable drawable;
        if (person != null) {
            WSRoundedImageView wSRoundedImageView = this.roundImageView;
            drawable = wSRoundedImageView != null ? wSRoundedImageView.getDrawable() : null;
            if (drawable instanceof FaceDrawable) {
                ((FaceDrawable) drawable).cancel();
            }
            WSPicLoader.g().k(o(), this.roundImageView, person.avatar, new WSPicLoader.d() { // from class: b00.g
                @Override // com.tencent.biz.pubaccount.weishi.image.WSPicLoader.d
                public final void a(Drawable drawable2) {
                    h.R(h.this, drawable2);
                }
            });
            return;
        }
        String y16 = bb.y();
        Drawable defaultDrawable = FaceDrawable.getDefaultDrawable(1, 3);
        FaceDrawable faceDrawable = FaceDrawable.getFaceDrawable(bb.t(), 1, y16, 3, defaultDrawable, defaultDrawable, null);
        WSRoundedImageView wSRoundedImageView2 = this.roundImageView;
        drawable = wSRoundedImageView2 != null ? wSRoundedImageView2.getDrawable() : null;
        if (drawable instanceof FaceDrawable) {
            ((FaceDrawable) drawable).cancel();
        }
        WSRoundedImageView wSRoundedImageView3 = this.roundImageView;
        if (wSRoundedImageView3 != null) {
            wSRoundedImageView3.setImageDrawable(faceDrawable);
        }
        ba.A(this.roundImageView, faceDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H() {
    }
}
