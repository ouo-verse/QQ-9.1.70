package com.tencent.mobileqq.troop.edittroopinfo.parts;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 '2\u00020\u0001:\u0001(B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u00a2\u0006\u0004\b%\u0010&J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\u0012\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0010H\u0016J\u0012\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\nH\u0016J\"\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\n0\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/troop/edittroopinfo/parts/EditTroopTagsPart;", "Lcom/tencent/mobileqq/troop/edittroopinfo/parts/base/a;", "", "", ComicCancelRedPointPopItemData.JSON_KEY_TAGS, "", "V9", "tag", "", NodeProps.MARGIN_RIGHT, "Landroid/view/View;", "P9", "Q9", "Landroid/content/Intent;", "data", "R9", "Lcom/tencent/mobileqq/troop/troopsetting/customconfig/b;", "O9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "requestCode", QzoneIPCModule.RESULT_CODE, "onActivityResult", "Landroidx/lifecycle/LifecycleOwner;", "e", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Landroid/widget/LinearLayout;", "f", "Landroid/widget/LinearLayout;", "tagLayout", tl.h.F, "Landroid/view/View;", "tagNoSet", "i", "Lcom/tencent/mobileqq/troop/troopsetting/customconfig/b;", "troopTagsConfig", "<init>", "(Landroidx/lifecycle/LifecycleOwner;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class EditTroopTagsPart extends com.tencent.mobileqq.troop.edittroopinfo.parts.base.a {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner lifecycleOwner;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private LinearLayout tagLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View tagNoSet;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.troop.troopsetting.customconfig.b<View> troopTagsConfig;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/edittroopinfo/parts/EditTroopTagsPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.edittroopinfo.parts.EditTroopTagsPart$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32636);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public EditTroopTagsPart(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) lifecycleOwner);
        } else {
            this.lifecycleOwner = lifecycleOwner;
        }
    }

    private final View P9(String tag, int marginRight) {
        TextView textView = new TextView(getContext());
        textView.setText(tag);
        textView.setTextColor(textView.getContext().getColor(R.color.qui_common_text_secondary));
        textView.setTextSize(0, ViewUtils.dip2px(12.0f));
        textView.setMaxLines(1);
        int dip2px = ViewUtils.dip2px(8.0f);
        int dip2px2 = ViewUtils.dip2px(4.0f);
        textView.setPadding(dip2px, dip2px2, dip2px, dip2px2);
        textView.setBackgroundResource(R.drawable.qui_common_fill_standard_primary_bg_corner_4);
        textView.setIncludeFontPadding(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = marginRight;
        textView.setLayoutParams(layoutParams);
        return textView;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void Q9() {
        List<String> list;
        boolean z16;
        Long l3;
        boolean z17;
        String str;
        String str2;
        boolean z18;
        boolean z19;
        boolean z26;
        TroopInfo g26 = C9().g2();
        String str3 = null;
        if (g26 != null) {
            list = com.tencent.mobileqq.troop.troopsetting.modules.base.b.f301142a.a(g26);
        } else {
            list = null;
        }
        Intent intent = new Intent(getContext(), ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).getTroopTagViewActivityClass());
        intent.putExtra("troopuin", C9().m2());
        if (g26 != null) {
            z16 = g26.isOwnerOrAdmin();
        } else {
            z16 = false;
        }
        intent.putExtra("isAdmin", z16);
        if (g26 != null) {
            l3 = Long.valueOf(g26.dwGroupClassExt);
        } else {
            l3 = null;
        }
        com.tencent.mobileqq.troop.troopcatalog.a c16 = com.tencent.mobileqq.troop.troopcatalog.b.g().c(String.valueOf(l3));
        if (c16 != null) {
            if (!TextUtils.isEmpty(c16.f299960b) && !Intrinsics.areEqual(c16.f299960b, HardCodeUtil.qqStr(R.string.ui_))) {
                str = c16.f299960b;
                z19 = true;
            }
            str = "";
            z19 = false;
        } else {
            if (g26 != null && (str2 = g26.mGroupClassExtText) != null) {
                if (str2.length() > 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    z17 = true;
                    if (z17) {
                        str = g26.mGroupClassExtText;
                        z19 = true;
                    }
                    str = "";
                    z19 = false;
                }
            }
            z17 = false;
            if (z17) {
            }
            str = "";
            z19 = false;
        }
        if (z19) {
            intent.putExtra("subclass", str);
        }
        List<String> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            z26 = false;
        } else {
            z26 = true;
        }
        if (!z26) {
            StringBuffer stringBuffer = new StringBuffer();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                stringBuffer.append(it.next() + "\n");
            }
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            intent.putExtra(ComicCancelRedPointPopItemData.JSON_KEY_TAGS, stringBuffer.toString());
        }
        intent.putExtra("act_type", 1);
        AppInterface e16 = bg.e();
        if (e16 != null) {
            str3 = e16.getCurrentAccountUin();
        }
        intent.putExtra("uin", str3);
        intent.putExtra("modifyToSrv", 0);
        getActivity().startActivityForResult(intent, 9);
    }

    private final void R9(Intent data) {
        String str;
        if (data != null) {
            str = data.getStringExtra(ComicCancelRedPointPopItemData.JSON_KEY_TAGS);
        } else {
            str = null;
        }
        boolean z16 = true;
        QLog.i("EditTroopInfoFragment-TagsPart", 1, "[onChooseTroopTag] tagsStr:" + str);
        if (str != null && str.length() != 0) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                try {
                    arrayList.add(jSONArray.getString(i3));
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
        } catch (JSONException e17) {
            e17.printStackTrace();
        }
        C9().w2(arrayList, this.lifecycleOwner);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(EditTroopTagsPart this$0, View view) {
        LinearLayout linearLayout;
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Q9();
        LinearLayout linearLayout2 = this$0.tagLayout;
        List<String> list = null;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tagLayout");
            linearLayout = null;
        } else {
            linearLayout = linearLayout2;
        }
        TroopInfo g26 = this$0.C9().g2();
        if (g26 != null) {
            list = com.tencent.mobileqq.troop.troopsetting.modules.base.b.f301142a.a(g26);
        }
        List<String> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        com.tencent.mobileqq.troop.edittroopinfo.parts.base.c.G9(this$0, linearLayout, !z16, null, null, 12, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(EditTroopTagsPart this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        List<String> value = this$0.C9().l2().getValue();
        if (value != null) {
            this$0.V9(value);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V9(final List<String> tags) {
        int i3;
        View view = this.tagNoSet;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tagNoSet");
            view = null;
        }
        if (tags.isEmpty()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.troop.edittroopinfo.parts.aj
            @Override // java.lang.Runnable
            public final void run() {
                EditTroopTagsPart.W9(EditTroopTagsPart.this, tags);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(EditTroopTagsPart this$0, List tags) {
        boolean z16;
        int coerceAtLeast;
        int dip2px;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(tags, "$tags");
        Activity activity = this$0.getActivity();
        if (activity != null && !activity.isFinishing()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return;
        }
        LinearLayout linearLayout = this$0.tagLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tagLayout");
            linearLayout = null;
        }
        linearLayout.removeAllViews();
        LinearLayout linearLayout2 = this$0.tagLayout;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tagLayout");
            linearLayout2 = null;
        }
        int width = linearLayout2.getWidth();
        LinearLayout linearLayout3 = this$0.tagLayout;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tagLayout");
            linearLayout3 = null;
        }
        int paddingLeft = width - linearLayout3.getPaddingLeft();
        LinearLayout linearLayout4 = this$0.tagLayout;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tagLayout");
            linearLayout4 = null;
        }
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(0, paddingLeft - linearLayout4.getPaddingRight());
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        Iterator it = tags.iterator();
        int i3 = 0;
        int i16 = 0;
        while (it.hasNext()) {
            int i17 = i3 + 1;
            String str = (String) it.next();
            if (i17 == tags.size()) {
                dip2px = 0;
            } else {
                dip2px = ViewUtils.dip2px(6.0f);
            }
            View P9 = this$0.P9(str, dip2px);
            P9.measure(makeMeasureSpec, makeMeasureSpec);
            int measuredWidth = i16 + P9.getMeasuredWidth();
            if (i3 < 5) {
                if (measuredWidth <= coerceAtLeast || coerceAtLeast == 0) {
                    i16 = measuredWidth + dip2px;
                    if (i16 > coerceAtLeast && coerceAtLeast != 0) {
                        ViewGroup.LayoutParams layoutParams = P9.getLayoutParams();
                        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        } else {
                            marginLayoutParams = null;
                        }
                        if (marginLayoutParams != null) {
                            marginLayoutParams.rightMargin = 0;
                        }
                    }
                    LinearLayout linearLayout5 = this$0.tagLayout;
                    if (linearLayout5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tagLayout");
                        linearLayout5 = null;
                    }
                    linearLayout5.addView(P9);
                    i3 = i17;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.edittroopinfo.parts.base.a
    @NotNull
    /* renamed from: O9, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.troop.troopsetting.customconfig.b<View> I9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.troop.troopsetting.customconfig.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        com.tencent.mobileqq.troop.troopsetting.customconfig.b<View> bVar = this.troopTagsConfig;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopTagsConfig");
            return null;
        }
        return bVar;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
        if (-1 == resultCode && requestCode == 9) {
            R9(data);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        LinearLayout linearLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.hz8, (ViewGroup) null);
        View findViewById = inflate.findViewById(R.id.f101705vx);
        Intrinsics.checkNotNullExpressionValue(findViewById, "layout.findViewById(R.id.troop_edit_tags_layout)");
        this.tagLayout = (LinearLayout) findViewById;
        View findViewById2 = inflate.findViewById(R.id.f101715vy);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "layout.findViewById(R.id.troop_edit_tags_not_set)");
        this.tagNoSet = findViewById2;
        com.tencent.mobileqq.troop.troopsetting.customconfig.b<View> bVar = new com.tencent.mobileqq.troop.troopsetting.customconfig.b<>(inflate);
        bVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.edittroopinfo.parts.ag
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditTroopTagsPart.S9(EditTroopTagsPart.this, view);
            }
        });
        bVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.troop.edittroopinfo.parts.ah
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                EditTroopTagsPart.T9(EditTroopTagsPart.this, view);
            }
        });
        this.troopTagsConfig = bVar;
        LiveData<List<String>> l26 = C9().l2();
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        final Function1<List<? extends String>, Unit> function1 = new Function1<List<? extends String>, Unit>() { // from class: com.tencent.mobileqq.troop.edittroopinfo.parts.EditTroopTagsPart$onInitView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EditTroopTagsPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
                invoke2((List<String>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<String> it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                EditTroopTagsPart editTroopTagsPart = EditTroopTagsPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                editTroopTagsPart.V9(it);
            }
        };
        l26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.edittroopinfo.parts.ai
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EditTroopTagsPart.U9(Function1.this, obj);
            }
        });
        LinearLayout linearLayout2 = this.tagLayout;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tagLayout");
            linearLayout = null;
        } else {
            linearLayout = linearLayout2;
        }
        com.tencent.mobileqq.troop.edittroopinfo.parts.base.c.z9(this, linearLayout, "em_group_tag", null, null, null, 28, null);
    }
}
