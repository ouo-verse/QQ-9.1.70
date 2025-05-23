package com.tencent.mobileqq.qqshop.publicaccount;

import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.k;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqshop.publicaccount.adapter.HeadCardAdapter;
import com.tencent.mobileqq.qqshop.publicaccount.adapter.p;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.pay.api.impl.VasNativePayManagerImpl;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 .2\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b,\u0010-J \u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\nH\u0016J \u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\bH\u0016J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\nH\u0016R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u001fR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010#R\u0016\u0010'\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/qqshop/publicaccount/AIOShopComponentDelegateQQ;", "Lqx3/a;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqshop/publicaccount/adapter/p;", "Lkotlin/collections/ArrayList;", "i", "", "j", "", "width", h.F, "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "e", "position", "Lcom/tencent/mobileqq/aio/msg/k;", "shopArkMsgItem", "", "d", "b", "stop", "c", "newState", "a", "Landroidx/viewpager2/widget/ViewPager2;", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "mainTitleText", "mainTimeText", "Lcom/tencent/mobileqq/qqshop/publicaccount/adapter/HeadCardAdapter;", "Lcom/tencent/mobileqq/qqshop/publicaccount/adapter/HeadCardAdapter;", "headCardAdapter", "", "J", "lastBindMsgId", "Ljava/text/SimpleDateFormat;", "f", "Ljava/text/SimpleDateFormat;", "simpleDateFormat", "<init>", "()V", "g", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class AIOShopComponentDelegateQQ implements qx3.a {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewPager2 viewPager;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mainTitleText;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mainTimeText;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private HeadCardAdapter headCardAdapter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long lastBindMsgId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SimpleDateFormat simpleDateFormat;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqshop/publicaccount/AIOShopComponentDelegateQQ$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqshop.publicaccount.AIOShopComponentDelegateQQ$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqshop/publicaccount/AIOShopComponentDelegateQQ$b", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "position", "", "onPageSelected", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b extends ViewPager2.OnPageChangeCallback {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOShopComponentDelegateQQ.this);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, position);
                return;
            }
            super.onPageSelected(position);
            HeadCardAdapter headCardAdapter = AIOShopComponentDelegateQQ.this.headCardAdapter;
            if (headCardAdapter != null) {
                headCardAdapter.n0(position);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30130);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOShopComponentDelegateQQ() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd", Locale.getDefault());
        }
    }

    private final int h(int width) {
        return ((int) ((width - ViewUtils.dip2px(30.0f)) * 0.56f)) + ViewUtils.dip2px(93.0f);
    }

    private final ArrayList<p> i(MsgRecord msgRecord) {
        boolean z16;
        com.tencent.mobileqq.qqshop.message.d dVar = com.tencent.mobileqq.qqshop.message.d.f274478a;
        qq_ad_get.QQAdGetRsp.AdInfo f16 = dVar.f(msgRecord);
        JSONArray u16 = dVar.u(msgRecord);
        if (u16 == null) {
            u16 = new JSONArray();
        }
        ArrayList<p> arrayList = new ArrayList<>();
        if (!j(msgRecord) && f16 != null) {
            p pVar = new p(f16, msgRecord);
            if (pVar.e().length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(pVar);
            }
        }
        int length = u16.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject = u16.optJSONObject(i3);
            String optString = optJSONObject.optString("bannerID");
            Intrinsics.checkNotNullExpressionValue(optString, "banner.optString(\"bannerID\")");
            String optString2 = optJSONObject.optString("image");
            Intrinsics.checkNotNullExpressionValue(optString2, "banner.optString(\"image\")");
            String optString3 = optJSONObject.optString("url");
            Intrinsics.checkNotNullExpressionValue(optString3, "banner.optString(\"url\")");
            String optString4 = optJSONObject.optString("title");
            Intrinsics.checkNotNullExpressionValue(optString4, "banner.optString(\"title\")");
            String optString5 = optJSONObject.optString("detail");
            Intrinsics.checkNotNullExpressionValue(optString5, "banner.optString(\"detail\")");
            arrayList.add(new p(optString, optString2, optString3, optString4, optString5, com.tencent.mobileqq.qqshop.message.d.f274478a.o(msgRecord)));
        }
        return arrayList;
    }

    private final boolean j(MsgRecord msgRecord) {
        return c.f274574a.c(msgRecord.msgId);
    }

    @Override // qx3.a
    public void a(int newState) {
        HeadCardAdapter headCardAdapter;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, newState);
        } else if (newState == 0 && (headCardAdapter = this.headCardAdapter) != null) {
            headCardAdapter.o0();
        }
    }

    @Override // qx3.a
    public boolean b(@NotNull MsgRecord msgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) msgRecord)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        return com.tencent.mobileqq.qqshop.message.d.f274478a.i(msgRecord);
    }

    @Override // qx3.a
    public void c(boolean stop) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, stop);
            return;
        }
        HeadCardAdapter headCardAdapter = this.headCardAdapter;
        if (headCardAdapter != null) {
            headCardAdapter.p0(stop);
        }
    }

    @Override // qx3.a
    public void d(@NotNull MsgRecord msgRecord, int position, @NotNull k shopArkMsgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, msgRecord, Integer.valueOf(position), shopArkMsgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(shopArkMsgItem, "shopArkMsgItem");
        long j3 = msgRecord.msgId;
        long j16 = this.lastBindMsgId;
        if (j3 == j16) {
            QLog.d("AIOShopComponentDelegate", 1, "bindComponentMsg return lastBindMsgId=" + j16 + " position=" + position + " msgId=" + j3);
            return;
        }
        this.lastBindMsgId = j3;
        QLog.d("AIOShopComponentDelegate", 1, "bindComponentMsg position=" + position + " msgId=" + j3 + " time=" + msgRecord.msgTime);
        ArrayList<p> i3 = i(msgRecord);
        if (i3.isEmpty()) {
            ViewPager2 viewPager2 = this.viewPager;
            if (viewPager2 != null) {
                viewPager2.setVisibility(8);
            }
        } else {
            ViewPager2 viewPager22 = this.viewPager;
            if (viewPager22 != null) {
                viewPager22.setVisibility(0);
            }
            HeadCardAdapter headCardAdapter = new HeadCardAdapter(i3, position, shopArkMsgItem.c(), new AIOShopComponentDelegateQQ$bindComponentMsg$headCardAdapter$1(i3, this, msgRecord));
            ViewPager2 viewPager23 = this.viewPager;
            if (viewPager23 != null) {
                viewPager23.setAdapter(headCardAdapter);
            }
            this.headCardAdapter = headCardAdapter;
        }
        com.tencent.mobileqq.qqshop.message.d dVar = com.tencent.mobileqq.qqshop.message.d.f274478a;
        if (dVar.i(msgRecord)) {
            String l3 = dVar.l(msgRecord);
            TextView textView = this.mainTitleText;
            if (textView != null) {
                if (l3 != null && l3.length() != 0) {
                    z16 = false;
                }
                if (z16) {
                    l3 = "\u4eca\u65e5\u798f\u5229\u7cbe\u9009";
                }
                textView.setText(l3);
            }
            TextView textView2 = this.mainTitleText;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            TextView textView3 = this.mainTimeText;
            if (textView3 != null) {
                textView3.setText(this.simpleDateFormat.format(new Date(msgRecord.msgTime * 1000)));
            }
            TextView textView4 = this.mainTimeText;
            if (textView4 != null) {
                textView4.setVisibility(0);
                return;
            }
            return;
        }
        TextView textView5 = this.mainTitleText;
        if (textView5 != null) {
            textView5.setVisibility(8);
        }
        TextView textView6 = this.mainTimeText;
        if (textView6 != null) {
            textView6.setVisibility(8);
        }
    }

    @Override // qx3.a
    @NotNull
    public View e(@NotNull ViewGroup parent, int width) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parent, width);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = View.inflate(parent.getContext(), R.layout.h4p, parent);
        View findViewById = inflate.findViewById(R.id.f624730x);
        Intrinsics.checkNotNullExpressionValue(findViewById, "myFrameLayout.findViewBy\u2026R.id.qq_shop_view_pager2)");
        ViewPager2 viewPager2 = (ViewPager2) findViewById;
        viewPager2.getLayoutParams().height = h(width);
        this.mainTitleText = (TextView) inflate.findViewById(R.id.f623130h);
        this.mainTimeText = (TextView) inflate.findViewById(R.id.f623030g);
        Typeface createFromAsset = Typeface.createFromAsset(parent.getContext().getAssets(), VasNativePayManagerImpl.DINALTERNATE_BOLD_FONT_PATH);
        TextView textView = this.mainTimeText;
        if (textView != null) {
            textView.setTypeface(createFromAsset);
        }
        viewPager2.setOffscreenPageLimit(1);
        viewPager2.setPageTransformer(new MarginPageTransformer(ViewUtils.dip2px(10.0f)));
        viewPager2.registerOnPageChangeCallback(new b());
        this.viewPager = viewPager2;
        View findViewById2 = inflate.findViewById(R.id.f84654mu);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "myFrameLayout.findViewById(R.id.shop_ad_container)");
        return findViewById2;
    }
}
