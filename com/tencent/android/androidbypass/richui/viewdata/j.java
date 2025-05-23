package com.tencent.android.androidbypass.richui.viewdata;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.android.androidbypass.richui.view.RichUIFrameLayout;
import com.tencent.android.androidbypass.richui.view.RoundLinearLayout;
import com.tencent.android.androidbypass.richui.view.l;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 @2\u00020\u0001:\u0001AB\u000f\u0012\u0006\u0010=\u001a\u00020<\u00a2\u0006\u0004\b>\u0010?J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0006\u0010\n\u001a\u00020\tJ\b\u0010\u000b\u001a\u00020\u0002H\u0016J\"\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0014\u001a\u00020\tH\u0016J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0006H\u0016J4\u0010\u001c\u001a\u00020\u00022*\u0010\u001b\u001a&\u0012\u0004\u0012\u00020\t\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00190\u0018j\u0012\u0012\u0004\u0012\u00020\t\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0019`\u001aH\u0016J4\u0010\u001d\u001a\u00020\u00022*\u0010\u001b\u001a&\u0012\u0004\u0012\u00020\t\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00190\u0018j\u0012\u0012\u0004\u0012\u00020\t\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0019`\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u0002H\u0016R$\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u001fj\b\u0012\u0004\u0012\u00020\u0001` 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010,R\u0018\u0010/\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0018\u00102\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u00101R\u0016\u00105\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00104R\u0016\u0010;\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u00104\u00a8\u0006B"}, d2 = {"Lcom/tencent/android/androidbypass/richui/viewdata/j;", "Lcom/tencent/android/androidbypass/richui/viewdata/k;", "", "G", "Lcom/tencent/android/androidbypass/richui/view/k;", "E", "Lorg/json/JSONObject;", "dataJson", "w", "", UserInfo.SEX_FEMALE, "y", "Landroid/content/Context;", "context", "Lcom/tencent/android/androidbypass/richui/view/i;", "viewDelegateFactory", "Lcom/tencent/android/androidbypass/richui/view/j;", "listener", "Landroid/view/View;", "f", "id", "g", "attrData", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/HashMap;", "Lcom/tencent/android/androidbypass/richui/view/h;", "Lkotlin/collections/HashMap;", "cache", "e", "d", "u", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "t", "Ljava/util/ArrayList;", "childList", "Lcom/tencent/android/androidbypass/richui/view/e;", "Lcom/tencent/android/androidbypass/richui/view/e;", "bgView", "Lcom/tencent/android/androidbypass/richui/view/RoundLinearLayout;", "v", "Lcom/tencent/android/androidbypass/richui/view/RoundLinearLayout;", "linearLayout", "Lcom/tencent/android/androidbypass/richui/view/RichUIFrameLayout;", "Lcom/tencent/android/androidbypass/richui/view/RichUIFrameLayout;", "innerFrameLayout", HippyTKDListViewAdapter.X, "frameLayout", "", "Ljava/lang/Integer;", "direction", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Ljava/lang/String;", "templateId", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "I", "busId", "B", "summary", "uuid", "Lcom/tencent/android/androidbypass/richui/f;", "options", "<init>", "(Lcom/tencent/android/androidbypass/richui/f;)V", "D", "a", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class j extends k {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    public static final Companion INSTANCE;

    /* renamed from: A, reason: from kotlin metadata */
    private int busId;

    /* renamed from: B, reason: from kotlin metadata */
    private String summary;

    /* renamed from: C, reason: from kotlin metadata */
    private String uuid;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<k> childList;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private com.tencent.android.androidbypass.richui.view.e bgView;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private RoundLinearLayout linearLayout;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private RichUIFrameLayout innerFrameLayout;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private RichUIFrameLayout frameLayout;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    private Integer direction;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    private String templateId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/android/androidbypass/richui/viewdata/j$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "bypass_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.android.androidbypass.richui.viewdata.j$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/android/androidbypass/richui/viewdata/j$b", "Lcom/tencent/android/androidbypass/richui/view/k;", "", QCircleWeakNetReporter.KEY_COST, "", "c", "b", "a", "bypass_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public static final class b implements com.tencent.android.androidbypass.richui.view.k {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            }
        }

        @Override // com.tencent.android.androidbypass.richui.view.k
        public void a(long cost) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, cost);
                return;
            }
            com.tencent.android.androidbypass.config.a.f72049a.i("RichUI.ViewGroupData", "[perfCallback]: draw cost=" + cost + " ms");
        }

        @Override // com.tencent.android.androidbypass.richui.view.k
        public void b(long cost) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, cost);
                return;
            }
            com.tencent.android.androidbypass.config.a.f72049a.i("RichUI.ViewGroupData", "[perfCallback]: layout cost=" + cost + " ms");
        }

        @Override // com.tencent.android.androidbypass.richui.view.k
        public void c(long cost) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, cost);
                return;
            }
            com.tencent.android.androidbypass.config.a.f72049a.i("RichUI.ViewGroupData", "[perfCallback]: measure cost=" + cost + " ms");
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19098);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@NotNull com.tencent.android.androidbypass.richui.f options) {
        super(options);
        Intrinsics.checkNotNullParameter(options, "options");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) options);
            return;
        }
        this.childList = new ArrayList<>();
        this.templateId = "";
        this.summary = "";
        this.uuid = "";
    }

    private final com.tencent.android.androidbypass.richui.view.k E() {
        if (o().f()) {
            return new b();
        }
        return null;
    }

    private final void G() {
        this.templateId = o().d().c();
        this.busId = o().d().a();
        this.summary = o().d().b();
        this.uuid = o().d().d();
    }

    @Override // com.tencent.android.androidbypass.richui.viewdata.k
    public void C(@NotNull JSONObject attrData) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) attrData);
            return;
        }
        Intrinsics.checkNotNullParameter(attrData, "attrData");
        super.C(attrData);
        com.tencent.android.androidbypass.richui.view.e eVar = this.bgView;
        if (eVar != null) {
            if (attrData.has("src")) {
                String optString = attrData.optString("src");
                Intrinsics.checkNotNullExpressionValue(optString, "attrData.optString(CommonConstants.JSON_KEY_SRC)");
                A(optString);
                if (j().length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    eVar.c(j(), ImageView.ScaleType.CENTER_CROP);
                } else {
                    eVar.getTextView().setImageDrawable(null);
                }
            }
            if (attrData.has("radius")) {
                B(attrData.optInt("radius"));
                Context context = eVar.getTextView().getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                eVar.e(vt.a.a(context, p()), 1);
                RoundLinearLayout roundLinearLayout = this.linearLayout;
                if (roundLinearLayout != null) {
                    roundLinearLayout.setMRadius(vt.a.a(context, p()));
                }
                RoundLinearLayout roundLinearLayout2 = this.linearLayout;
                if (roundLinearLayout2 != null) {
                    roundLinearLayout2.invalidate();
                }
            }
        }
    }

    @NotNull
    public final String F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.templateId;
    }

    @Override // com.tencent.android.androidbypass.richui.viewdata.k
    public void d(@NotNull HashMap<String, com.tencent.android.androidbypass.richui.view.h<?>> cache) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) cache);
            return;
        }
        Intrinsics.checkNotNullParameter(cache, "cache");
        com.tencent.android.androidbypass.richui.view.h<?> hVar = cache.get(q());
        if (!(hVar instanceof l)) {
            hVar = null;
        }
        l lVar = (l) hVar;
        if (lVar != null) {
            this.bgView = lVar.j();
            this.linearLayout = lVar.m();
            this.frameLayout = lVar.k();
            this.innerFrameLayout = lVar.l();
        }
        Iterator<T> it = this.childList.iterator();
        while (it.hasNext()) {
            ((k) it.next()).d(cache);
        }
    }

    @Override // com.tencent.android.androidbypass.richui.viewdata.k
    public void e(@NotNull HashMap<String, com.tencent.android.androidbypass.richui.view.h<?>> cache) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) cache);
            return;
        }
        Intrinsics.checkNotNullParameter(cache, "cache");
        Iterator<T> it = this.childList.iterator();
        while (it.hasNext()) {
            ((k) it.next()).e(cache);
        }
        cache.put(q(), new l(this.bgView, this.linearLayout, this.innerFrameLayout, this.frameLayout));
        this.bgView = null;
        this.linearLayout = null;
        this.frameLayout = null;
        this.innerFrameLayout = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.android.androidbypass.richui.viewdata.k
    @NotNull
    protected View f(@NotNull Context context, @NotNull com.tencent.android.androidbypass.richui.view.i viewDelegateFactory, @Nullable com.tencent.android.androidbypass.richui.view.j listener) {
        boolean z16;
        com.tencent.android.androidbypass.richui.view.e eVar;
        RoundLinearLayout roundLinearLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, this, context, viewDelegateFactory, listener);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewDelegateFactory, "viewDelegateFactory");
        if (j().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        ViewGroup.LayoutParams layoutParams = null;
        if (z16) {
            eVar = this.bgView;
            if (eVar == null) {
                eVar = viewDelegateFactory.b(context);
            }
            eVar.c(j(), ImageView.ScaleType.CENTER_CROP);
            eVar.e(vt.a.a(context, p()), 1);
            c(eVar.getTextView());
            this.bgView = eVar;
        } else {
            eVar = null;
        }
        if (this.direction == null) {
            RichUIFrameLayout richUIFrameLayout = this.innerFrameLayout;
            RichUIFrameLayout richUIFrameLayout2 = richUIFrameLayout;
            if (richUIFrameLayout == null) {
                richUIFrameLayout2 = new RichUIFrameLayout(context);
            }
            this.innerFrameLayout = richUIFrameLayout2;
            richUIFrameLayout2.setMRadius(vt.a.a(context, p()));
            roundLinearLayout = richUIFrameLayout2;
        } else {
            RoundLinearLayout roundLinearLayout2 = this.linearLayout;
            RoundLinearLayout roundLinearLayout3 = roundLinearLayout2;
            if (roundLinearLayout2 == null) {
                roundLinearLayout3 = new RoundLinearLayout(context);
            }
            Integer num = this.direction;
            if (num != null) {
                roundLinearLayout3.setOrientation(num.intValue());
            }
            this.linearLayout = roundLinearLayout3;
            roundLinearLayout3.setMRadius(vt.a.a(context, p()));
            roundLinearLayout = roundLinearLayout3;
        }
        roundLinearLayout.removeAllViews();
        for (k kVar : this.childList) {
            View h16 = kVar.h(context, viewDelegateFactory, listener);
            ViewParent parent = h16.getParent();
            if (!(parent instanceof ViewGroup)) {
                parent = null;
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup != null) {
                viewGroup.removeView(h16);
            }
            if (this.direction == null) {
                ViewGroup.LayoutParams layoutParams2 = h16.getLayoutParams();
                if (!(layoutParams2 instanceof LinearLayout.LayoutParams)) {
                    layoutParams2 = null;
                }
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams2;
                if (layoutParams3 != null) {
                    h16.setLayoutParams(kVar.l(context, layoutParams3));
                }
            }
            roundLinearLayout.addView(h16);
        }
        c(roundLinearLayout);
        if (eVar != null) {
            RichUIFrameLayout richUIFrameLayout3 = this.frameLayout;
            RichUIFrameLayout richUIFrameLayout4 = richUIFrameLayout3;
            if (richUIFrameLayout3 == null) {
                richUIFrameLayout4 = new RichUIFrameLayout(context);
            }
            this.frameLayout = richUIFrameLayout4;
            ImageView textView = eVar.getTextView();
            ImageView imageView = textView;
            ViewParent parent2 = imageView.getParent();
            if (!(parent2 instanceof ViewGroup)) {
                parent2 = null;
            }
            ViewGroup viewGroup2 = (ViewGroup) parent2;
            if (viewGroup2 != null) {
                viewGroup2.removeView(imageView);
            }
            Unit unit = Unit.INSTANCE;
            richUIFrameLayout4.addView(textView);
            ViewParent parent3 = roundLinearLayout.getParent();
            if (!(parent3 instanceof ViewGroup)) {
                parent3 = null;
            }
            ViewGroup viewGroup3 = (ViewGroup) parent3;
            if (viewGroup3 != null) {
                viewGroup3.removeView(roundLinearLayout);
            }
            richUIFrameLayout4.addView(roundLinearLayout);
            c(richUIFrameLayout4);
            ViewGroup.LayoutParams layoutParams4 = richUIFrameLayout4.getLayoutParams();
            if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                layoutParams = layoutParams4;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (marginLayoutParams != null) {
                marginLayoutParams.setMargins(0, 0, 0, 0);
            }
            richUIFrameLayout4.setPerfCallback(E());
            return richUIFrameLayout4;
        }
        return roundLinearLayout;
    }

    @Override // com.tencent.android.androidbypass.richui.viewdata.k
    @Nullable
    public k g(@NotNull String id5) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (k) iPatchRedirector.redirect((short) 5, (Object) this, (Object) id5);
        }
        Intrinsics.checkNotNullParameter(id5, "id");
        if (id5.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && Intrinsics.areEqual(q(), id5)) {
            return this;
        }
        Iterator<k> it = this.childList.iterator();
        while (it.hasNext()) {
            k g16 = it.next().g(id5);
            if (g16 != null) {
                return g16;
            }
        }
        return null;
    }

    @Override // com.tencent.android.androidbypass.richui.viewdata.k
    public void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        Iterator<T> it = this.childList.iterator();
        while (it.hasNext()) {
            ((k) it.next()).u();
        }
    }

    @Override // com.tencent.android.androidbypass.richui.viewdata.k
    public void w(@NotNull JSONObject dataJson) {
        Integer valueOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) dataJson);
            return;
        }
        Intrinsics.checkNotNullParameter(dataJson, "dataJson");
        super.w(dataJson);
        G();
        JSONObject c16 = o().c();
        JSONObject a16 = o().a();
        if (!c16.has("direction")) {
            valueOf = null;
        } else {
            valueOf = Integer.valueOf(c16.optString("direction").equals("vertical") ? 1 : 0);
        }
        this.direction = valueOf;
        if (c16.has(TtmlNode.TAG_LAYOUT) && a16.has("attributes")) {
            JSONArray jSONArray = c16.getJSONArray(TtmlNode.TAG_LAYOUT);
            JSONArray jSONArray2 = a16.getJSONArray("attributes");
            int length = jSONArray.length();
            int i3 = 0;
            int i16 = 0;
            while (i16 < length) {
                JSONObject childLayout = jSONArray.getJSONObject(i16);
                JSONObject childAttr = jSONArray2.getJSONObject(i16);
                int optInt = childAttr.optInt("version", i3);
                if (childLayout.has(TtmlNode.TAG_LAYOUT) && childAttr.has("attributes")) {
                    Intrinsics.checkNotNullExpressionValue(childLayout, "childLayout");
                    Intrinsics.checkNotNullExpressionValue(childAttr, "childAttr");
                    this.childList.add(new j(new com.tencent.android.androidbypass.richui.f(childLayout, childAttr, this.direction, false, new com.tencent.android.androidbypass.richui.d(null, 0, null, null, optInt, 15, null), o().e())));
                } else {
                    ArrayList<k> arrayList = this.childList;
                    com.tencent.android.androidbypass.richui.utils.b bVar = com.tencent.android.androidbypass.richui.utils.b.f72344a;
                    Intrinsics.checkNotNullExpressionValue(childLayout, "childLayout");
                    Intrinsics.checkNotNullExpressionValue(childAttr, "childAttr");
                    arrayList.add(bVar.a(childLayout, childAttr, this.direction, o().e()));
                }
                i16++;
                i3 = 0;
            }
        } else {
            com.tencent.android.androidbypass.config.a.f72049a.e("RichUI.ViewGroupData", "[parse]: jsonData invalid, not have layout and itemLayout");
        }
        Iterator<T> it = this.childList.iterator();
        while (it.hasNext()) {
            ((k) it.next()).w(dataJson);
        }
    }

    @Override // com.tencent.android.androidbypass.richui.viewdata.k
    public void y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.y();
        Iterator<T> it = this.childList.iterator();
        while (it.hasNext()) {
            ((k) it.next()).y();
        }
    }
}
