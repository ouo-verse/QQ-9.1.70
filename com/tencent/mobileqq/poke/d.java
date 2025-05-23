package com.tencent.mobileqq.poke;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.NTPEItemData;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u0007\u00a2\u0006\u0004\b)\u0010*J\u0016\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0007H\u0016J\"\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00030!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/poke/d;", "Landroid/widget/BaseAdapter;", "", "Lcom/tencent/mobileqq/data/NTPEItemData;", "dataList", "", "b", "", "getCount", "position", "", "getItem", "", "getItemId", "Landroid/view/View;", "convertView", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "getView", "", "filePath", "Landroid/graphics/drawable/Drawable;", "a", "Landroid/content/Context;", "d", "Landroid/content/Context;", "mContext", "e", "I", "mPanelHeight", "f", "Landroid/graphics/drawable/Drawable;", "mDefaultDrawable", "Ljava/util/ArrayList;", tl.h.F, "Ljava/util/ArrayList;", "mDataList", "", "i", UserInfo.SEX_FEMALE, "mPressScale", "<init>", "(Landroid/content/Context;I)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class d extends BaseAdapter {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context mContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int mPanelHeight;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Drawable mDefaultDrawable;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<NTPEItemData> mDataList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final float mPressScale;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/poke/d$a;", "", "", "TAG", "Ljava/lang/String;", "", "columnNum", "I", "<init>", "()V", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.poke.d$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25929);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public d(@NotNull Context mContext, int i3) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mContext, i3);
            return;
        }
        this.mContext = mContext;
        this.mPanelHeight = i3;
        Drawable drawable = mContext.getResources().getDrawable(R.drawable.d3s);
        Intrinsics.checkNotNullExpressionValue(drawable, "mContext.resources.getDr\u2026.drawable.pe_emo_default)");
        this.mDefaultDrawable = drawable;
        this.mDataList = new ArrayList<>();
        this.mPressScale = 1.25f;
    }

    @NotNull
    public final Drawable a(@Nullable String filePath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Drawable) iPatchRedirector.redirect((short) 7, (Object) this, (Object) filePath);
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = this.mDefaultDrawable;
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        obtain.mPlayGifImage = true;
        URLDrawable drawable2 = URLDrawable.getDrawable(new File(filePath), obtain);
        Intrinsics.checkNotNullExpressionValue(drawable2, "getDrawable(File(filePath), options)");
        return drawable2;
    }

    public final void b(@Nullable List<NTPEItemData> dataList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dataList);
            return;
        }
        this.mDataList.clear();
        if (dataList != null) {
            List<NTPEItemData> list = dataList;
            if (!list.isEmpty()) {
                this.mDataList.addAll(list);
            }
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return ((this.mDataList.size() + 4) - 1) / 4;
    }

    @Override // android.widget.Adapter
    @Nullable
    public Object getItem(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this, position);
        }
        if (this.mDataList.size() > position) {
            return this.mDataList.get(position);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this, position)).longValue();
        }
        return position;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r2v12, types: [android.widget.LinearLayout, android.view.View, com.tencent.mobileqq.poke.NTStickerBubbleLinearLayout, android.view.ViewGroup] */
    @Override // android.widget.Adapter
    @NotNull
    public View getView(int position, @Nullable View convertView, @NotNull ViewGroup parent) {
        ViewGroup viewGroup;
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 4;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            view = (View) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(position), convertView, parent);
        } else {
            Intrinsics.checkNotNullParameter(parent, "parent");
            int i16 = position * 4;
            int i17 = this.mPanelHeight;
            com.tencent.mobileqq.poke.utils.a aVar = com.tencent.mobileqq.poke.utils.a.f259088a;
            Resources resources = this.mContext.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "mContext.resources");
            int a16 = i17 - aVar.a(70.0f, resources);
            Resources resources2 = this.mContext.getResources();
            Intrinsics.checkNotNullExpressionValue(resources2, "mContext.resources");
            float f16 = 64.0f;
            int a17 = (a16 - (aVar.a(64.0f, resources2) * 2)) / 3;
            if (a17 < 0) {
                a17 = 0;
            }
            Resources resources3 = this.mContext.getResources();
            Intrinsics.checkNotNullExpressionValue(resources3, "mContext.resources");
            int a18 = aVar.a(10.0f, resources3);
            if (a17 < a18) {
                a17 = a18;
            }
            int i18 = this.mContext.getResources().getDisplayMetrics().widthPixels;
            Resources resources4 = this.mContext.getResources();
            Intrinsics.checkNotNullExpressionValue(resources4, "mContext.resources");
            int a19 = (i18 - (aVar.a(64.0f, resources4) * 4)) / 8;
            if (convertView == null) {
                viewGroup = new NTStickerBubbleLinearLayout(this.mContext);
                Resources resources5 = this.mContext.getResources();
                Intrinsics.checkNotNullExpressionValue(resources5, "mContext.resources");
                viewGroup.setMinimumHeight(aVar.a(64.0f, resources5) + a17);
                viewGroup.setOrientation(0);
                int i19 = 0;
                while (i19 < i3) {
                    LinearLayout linearLayout = new LinearLayout(this.mContext);
                    linearLayout.setGravity(17);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    linearLayout.setLayoutParams(layoutParams);
                    layoutParams.weight = 1.0f;
                    com.tencent.mobileqq.poke.utils.a aVar2 = com.tencent.mobileqq.poke.utils.a.f259088a;
                    Resources resources6 = this.mContext.getResources();
                    Intrinsics.checkNotNullExpressionValue(resources6, "mContext.resources");
                    int a26 = aVar2.a(f16, resources6);
                    Resources resources7 = this.mContext.getResources();
                    Intrinsics.checkNotNullExpressionValue(resources7, "mContext.resources");
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(a26, aVar2.a(f16, resources7));
                    int i26 = a17 / 2;
                    layoutParams2.topMargin = i26;
                    layoutParams2.bottomMargin = i26;
                    View nTStickerBubbleImageView = new NTStickerBubbleImageView(this.mContext);
                    nTStickerBubbleImageView.setPadding(14, 14, 14, 14);
                    Resources resources8 = this.mContext.getResources();
                    Intrinsics.checkNotNullExpressionValue(resources8, "mContext.resources");
                    int a27 = aVar2.a(f16, resources8);
                    Resources resources9 = this.mContext.getResources();
                    Intrinsics.checkNotNullExpressionValue(resources9, "mContext.resources");
                    int a28 = aVar2.a(f16, resources9);
                    ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
                    shapeDrawable.setIntrinsicHeight(a27);
                    shapeDrawable.setIntrinsicWidth(a28);
                    shapeDrawable.getPaint().setColor(1728053247);
                    nTStickerBubbleImageView.setBackgroundDrawable(shapeDrawable);
                    nTStickerBubbleImageView.setLayoutParams(layoutParams2);
                    linearLayout.addView(nTStickerBubbleImageView);
                    viewGroup.addView(linearLayout);
                    i19++;
                    i3 = 4;
                    f16 = 64.0f;
                }
            } else {
                viewGroup = convertView;
            }
            ViewGroup viewGroup2 = viewGroup;
            if (position == 0) {
                viewGroup2.setPadding(0, a17 / 2, 0, 0);
            } else {
                viewGroup2.setPadding(0, 0, 0, 0);
            }
            int i27 = 4;
            for (int i28 = 0; i28 < i27; i28++) {
                int i29 = i16 + i28;
                View childAt = viewGroup2.getChildAt(i28);
                Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.view.ViewGroup");
                View childAt2 = ((ViewGroup) childAt).getChildAt(0);
                if (i29 < this.mDataList.size()) {
                    childAt2.setVisibility(0);
                    NTPEItemData nTPEItemData = this.mDataList.get(i29);
                    Intrinsics.checkNotNullExpressionValue(nTPEItemData, "mDataList[index]");
                    NTPEItemData nTPEItemData2 = nTPEItemData;
                    Intrinsics.checkNotNull(childAt2, "null cannot be cast to non-null type android.widget.ImageView");
                    ImageView imageView = (ImageView) childAt2;
                    imageView.setImageDrawable(a(nTPEItemData2.getLocalPath()));
                    imageView.setTag(Integer.valueOf(i29));
                    if (AppSetting.f99565y) {
                        imageView.setContentDescription(c.f258994a.c(nTPEItemData2.getPokeEmoId()) + HardCodeUtil.qqStr(R.string.pab));
                    }
                    i27 = 4;
                } else {
                    i27 = 4;
                    childAt2.setVisibility(4);
                }
            }
            viewGroup2.setOnLongClickListener(null);
            AccessibilityUtil.n(viewGroup, false);
            view = viewGroup;
        }
        EventCollector.getInstance().onListGetView(position, convertView, parent, getItemId(position));
        return view;
    }
}
