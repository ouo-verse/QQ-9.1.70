package com.tencent.mobileqq.qwallet.hb.aio.viewholder.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.INewQWalletApi;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.qwallet.hb.skin.HbSkinData;
import com.tencent.mobileqq.qwallet.hb.skin.HbSkinRepository;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPicHelper;
import d4.f;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import vk2.QWalletMsgModel;
import vk2.QWalletSessionInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 =2\u00020\u0001:\u0001\bB\u001f\u0012\u0006\u0010\u001a\u001a\u00020\u0016\u0012\u0006\u0010\u001f\u001a\u00020\u001b\u0012\u0006\u0010$\u001a\u00020 \u00a2\u0006\u0004\bC\u0010DJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0004J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0004R\u0017\u0010\u001a\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001f\u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010$\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010!\u001a\u0004\b\"\u0010#R\u001a\u0010)\u001a\u00020%8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010&\u001a\u0004\b'\u0010(R\"\u00100\u001a\u00020*8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00104\u001a\u00020\n8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\t\u00101\u001a\u0004\b2\u00103R$\u0010;\u001a\u0004\u0018\u0001058\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0016\u0010?\u001a\u0004\u0018\u00010<8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b=\u0010>R\u0014\u0010B\u001a\u00020\u00108DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b@\u0010A\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/aio/viewholder/impl/BaseViewHolderV2;", "Lyk2/a;", "Landroid/widget/TextView;", "grayBarView", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "g", "onCreate", "a", "f", "", "visibility", "o", "b", "d", "c", "", "e", "onResume", "", "stateText", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ld4/f;", "Ld4/f;", "k", "()Ld4/f;", "parentViewHolder", "Lvk2/d;", "Lvk2/d;", "j", "()Lvk2/d;", "model", "Lvk2/e;", "Lvk2/e;", "l", "()Lvk2/e;", "sessionInfo", "Lvk2/b;", "Lvk2/b;", "getElem", "()Lvk2/b;", "elem", "Landroid/content/Context;", "Landroid/content/Context;", "i", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "context", "I", "getSkinId", "()I", "skinId", "Lcom/tencent/mobileqq/qwallet/hb/skin/HbSkinData;", "Lcom/tencent/mobileqq/qwallet/hb/skin/HbSkinData;", "getHbSkinData", "()Lcom/tencent/mobileqq/qwallet/hb/skin/HbSkinData;", "p", "(Lcom/tencent/mobileqq/qwallet/hb/skin/HbSkinData;)V", "hbSkinData", "Lcom/tencent/common/app/business/BaseQQAppInterface;", h.F, "()Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", DomainData.DOMAIN_NAME, "()Z", "isShowSkin", "<init>", "(Ld4/f;Lvk2/d;Lvk2/e;)V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public class BaseViewHolderV2 implements yk2.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f parentViewHolder;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QWalletMsgModel model;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QWalletSessionInfo sessionInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final vk2.b elem;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Context context;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int skinId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private HbSkinData hbSkinData;

    public BaseViewHolderV2(@NotNull f parentViewHolder, @NotNull QWalletMsgModel model, @NotNull QWalletSessionInfo sessionInfo) {
        Intrinsics.checkNotNullParameter(parentViewHolder, "parentViewHolder");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
        this.parentViewHolder = parentViewHolder;
        this.model = model;
        this.sessionInfo = sessionInfo;
        vk2.b elem = model.getHbModel().getElem();
        this.elem = elem;
        Context context = parentViewHolder.getLayout().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parentViewHolder.layout.context");
        this.context = context;
        int i3 = elem.f441784v;
        this.skinId = i3;
        if (QLog.isColorLevel()) {
            QLog.d("BaseViewHolder", 2, "skinId=" + i3 + ",elem=" + elem);
        }
    }

    private final void g() {
        boolean z16;
        String redPacketId = this.model.getHbModel().getRedPacketId();
        if (redPacketId != null && redPacketId.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        ((INewQWalletApi) QRoute.api(INewQWalletApi.class)).getHbStateAsync(redPacketId, new BaseViewHolderV2$fetchStateTextAsync$1(this));
    }

    private final void m(TextView grayBarView) {
        Resources resources = grayBarView.getContext().getResources();
        grayBarView.setBackground(null);
        grayBarView.setPadding(0, 0, 0, 0);
        grayBarView.setTextColor(resources.getColor(R.color.bpx));
        grayBarView.setTextSize(12.0f);
        ViewGroup.LayoutParams layoutParams = grayBarView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = resources.getDimensionPixelSize(R.dimen.cgh);
            marginLayoutParams.rightMargin = 0;
            marginLayoutParams.leftMargin = 0;
            marginLayoutParams.bottomMargin = 0;
        }
        grayBarView.setLayoutParams(layoutParams);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x002c A[Catch: all -> 0x0039, TryCatch #0 {all -> 0x0039, blocks: (B:7:0x000a, B:9:0x0017, B:11:0x001f, B:17:0x0030, B:20:0x002c), top: B:6:0x000a }] */
    @Override // yk2.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a() {
        String str;
        boolean z16;
        RelativeLayout background = this.parentViewHolder.getBackground();
        if (background == null) {
            return;
        }
        try {
            Drawable drawable = ContextCompat.getDrawable(this.context, R.drawable.fpw);
            HbSkinData hbSkinData = this.hbSkinData;
            if (hbSkinData != null) {
                str = hbSkinData.getAioResUrl();
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                z16 = false;
                if (z16) {
                    drawable = QWalletPicHelper.getNetDrawableForQWallet(str, drawable, drawable);
                }
                background.setBackground(drawable);
                com.tencent.mobileqq.qwallet.utils.impl.b.a(background, 4.0f);
            }
            z16 = true;
            if (z16) {
            }
            background.setBackground(drawable);
            com.tencent.mobileqq.qwallet.utils.impl.b.a(background, 4.0f);
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e("BaseViewHolder", 1, "handleBackground throw exception: " + th5.getLocalizedMessage());
            }
        }
    }

    @Override // yk2.a
    public void b() {
        o(0);
        if (!n()) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ScreenUtil.dip2px(35.0f), ScreenUtil.dip2px(35.0f));
            layoutParams.gravity = 17;
            ImageView imageView = new ImageView(this.context);
            imageView.setImageResource(R.drawable.f162119fq3);
            this.parentViewHolder.f().addView(imageView, layoutParams);
        }
    }

    @Override // yk2.a
    public void c() {
        if (this.parentViewHolder.c() == null) {
            return;
        }
        this.parentViewHolder.c().setVisibility(8);
    }

    @Override // yk2.a
    public void d() {
        boolean z16;
        TextView b16 = this.parentViewHolder.b();
        TextView g16 = this.parentViewHolder.g();
        if (b16 != null && g16 != null) {
            String str = this.elem.f441765c;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                b16.setVisibility(8);
                g16.setVisibility(8);
            }
            if (n()) {
                b16.setVisibility(8);
                g16.setText(this.elem.f441765c);
                g16.setVisibility(0);
                return;
            }
            b16.setVisibility(0);
            g16.setVisibility(8);
            if (n()) {
                b16.setText("");
                return;
            }
            TextPaint paint = b16.getPaint();
            paint.setTextSize(ScreenUtil.dip2px(20.0f));
            if (paint.measureText(this.elem.f441765c) > ScreenUtil.dip2px(112.0f)) {
                b16.setTextSize(1, 14.0f);
            } else {
                b16.setTextSize(1, 20.0f);
            }
            b16.setText(this.elem.f441765c);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007d  */
    @Override // yk2.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean e() {
        CharSequence charSequence;
        boolean z16;
        boolean z17;
        CharSequence charSequence2;
        boolean isBlank;
        boolean isBlank2;
        HbSkinData.Tail tail;
        HbSkinData.Tail tail2;
        TextView a16 = this.parentViewHolder.a();
        if (a16 == null) {
            return false;
        }
        a16.setVisibility(0);
        if (this.sessionInfo.getInGuildLive()) {
            m(a16);
        } else if (QQTheme.isNowThemeIsNight()) {
            a16.setBackgroundResource(R.drawable.l_z);
            a16.setTextColor(Color.parseColor("#A5A5A5"));
        } else {
            a16.setBackgroundResource(R.drawable.l_y);
            a16.setTextColor(-1);
        }
        HbSkinData hbSkinData = this.hbSkinData;
        String str = null;
        if (hbSkinData != null && (tail2 = hbSkinData.getTail()) != null) {
            charSequence = tail2.getWord();
        } else {
            charSequence = null;
        }
        HbSkinData hbSkinData2 = this.hbSkinData;
        if (hbSkinData2 != null && (tail = hbSkinData2.getTail()) != null) {
            str = tail.getUrl();
        }
        if (str != null) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank2) {
                z16 = false;
                if (!z16) {
                    a16.setTag(str);
                }
                if (charSequence != null) {
                    isBlank = StringsKt__StringsJVMKt.isBlank(charSequence);
                    if (!isBlank) {
                        z17 = false;
                        if (!z17) {
                            a16.setText(charSequence);
                            return true;
                        }
                        int messageType = this.model.getMessageType();
                        if (messageType != 2) {
                            if (messageType != 3) {
                                charSequence2 = "QQ\u7ea2\u5305";
                            } else {
                                charSequence2 = "\u62fc\u624b\u6c14\u7ea2\u5305";
                            }
                        } else {
                            charSequence2 = "\u666e\u901a\u7ea2\u5305";
                        }
                        a16.setText(charSequence2);
                        return false;
                    }
                }
                z17 = true;
                if (!z17) {
                }
            }
        }
        z16 = true;
        if (!z16) {
        }
        if (charSequence != null) {
        }
        z17 = true;
        if (!z17) {
        }
    }

    @Override // yk2.a
    public void f() {
        String str;
        ImageView e16 = this.parentViewHolder.e();
        if (e16 == null) {
            return;
        }
        IQWalletHbApi iQWalletHbApi = (IQWalletHbApi) QRoute.api(IQWalletHbApi.class);
        HbSkinData hbSkinData = this.hbSkinData;
        if (hbSkinData != null) {
            str = hbSkinData.getPopOpenUrl();
        } else {
            str = null;
        }
        iQWalletHbApi.updateOpenIcon(e16, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final BaseQQAppInterface h() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof BaseQQAppInterface) {
            return (BaseQQAppInterface) peekAppRuntime;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: i, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final QWalletMsgModel getModel() {
        return this.model;
    }

    @NotNull
    /* renamed from: k, reason: from getter */
    public final f getParentViewHolder() {
        return this.parentViewHolder;
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final QWalletSessionInfo getSessionInfo() {
        return this.sessionInfo;
    }

    protected final boolean n() {
        boolean z16;
        vk2.b bVar = this.elem;
        if (bVar.f441784v > 0) {
            return true;
        }
        if (bVar.f441786x != 0) {
            String str = bVar.f441785w;
            Intrinsics.checkNotNullExpressionValue(str, "elem.outerSkinId");
            if (str.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void o(int visibility) {
        if (this.parentViewHolder.f() == null) {
            return;
        }
        this.parentViewHolder.f().setVisibility(visibility);
        if (this.parentViewHolder.f().getChildCount() != 0) {
            this.parentViewHolder.f().removeAllViews();
        }
    }

    @Override // yk2.a
    public void onCreate() {
        HbSkinRepository hbSkinRepository = HbSkinRepository.f277840a;
        vk2.b bVar = this.elem;
        int i3 = bVar.f441784v;
        String str = bVar.f441785w;
        if (str == null) {
            str = "";
        }
        hbSkinRepository.d(i3, str, bVar.f441786x, new Function1<HbSkinData, Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.aio.viewholder.impl.BaseViewHolderV2$onCreate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HbSkinData hbSkinData) {
                invoke2(hbSkinData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable HbSkinData hbSkinData) {
                BaseViewHolderV2.this.p(hbSkinData);
                BaseViewHolderV2.this.b();
                BaseViewHolderV2.this.c();
                BaseViewHolderV2.this.d();
                BaseViewHolderV2.this.a();
                BaseViewHolderV2.this.f();
                BaseViewHolderV2.this.e();
                BaseViewHolderV2.this.onResume();
            }
        });
    }

    @Override // yk2.a
    public void onResume() {
        if (this.parentViewHolder.h() == null) {
            return;
        }
        g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void p(@Nullable HbSkinData hbSkinData) {
        this.hbSkinData = hbSkinData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void q(@NotNull String stateText) {
        boolean z16;
        Intrinsics.checkNotNullParameter(stateText, "stateText");
        if (stateText.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.parentViewHolder.h().setVisibility(8);
            this.parentViewHolder.d().setVisibility(8);
        } else {
            this.parentViewHolder.h().setVisibility(0);
            this.parentViewHolder.g().setVisibility(8);
            this.parentViewHolder.d().setVisibility(0);
            this.parentViewHolder.d().setText(stateText);
        }
    }
}
