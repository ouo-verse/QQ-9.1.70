package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \"2\u00020\u0001:\u0001\u000eB'\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001e\u00a2\u0006\u0004\b \u0010!J.\u0010\n\u001a\u00020\t2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0007H\u0002J\u0014\u0010\u0010\u001a\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/TopTagViewContainerView;", "Landroid/widget/LinearLayout;", "linearContainer", "", "Landroid/widget/TextView;", "backupViews", "", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/g;", "tagDataList", "", "b", "Landroid/content/Context;", "context", "data", "a", "list", "c", "d", "Ljava/util/List;", "topViews", "e", "bottomViews", "f", "Landroid/widget/LinearLayout;", "topLinearContainer", tl.h.F, "bottomLinearContainer", "mContext", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class TopTagViewContainerView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<TextView> topViews;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<TextView> bottomViews;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout topLinearContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout bottomLinearContainer;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f319532i;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TopTagViewContainerView(@NotNull Context mContext) {
        this(mContext, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(mContext, "mContext");
    }

    private final TextView a(Context context, TagData data) {
        TextView textView = new TextView(context);
        textView.setBackgroundResource(R.drawable.m36);
        textView.setTextSize(9.0f);
        textView.setGravity(17);
        textView.setSingleLine();
        textView.setTextColor(-1);
        textView.setPadding(data.getContentPadding(), 0, data.getContentPadding(), 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(data.getWidth(), data.getHeight());
        com.tencent.videocut.utils.e eVar = com.tencent.videocut.utils.e.f384236a;
        layoutParams.leftMargin = eVar.a(4.0f);
        if (data.getAlignTop()) {
            layoutParams.gravity = 48;
            layoutParams.topMargin = eVar.a(2.0f);
        } else {
            layoutParams.gravity = 80;
            layoutParams.bottomMargin = eVar.a(1.0f);
        }
        textView.setLayoutParams(layoutParams);
        return textView;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void b(LinearLayout linearContainer, List<TextView> backupViews, List<TagData> tagDataList) {
        TextView textView;
        boolean z16;
        Drawable drawable;
        Drawable drawable2;
        Rect drawableRightBounds;
        Rect drawableLeftBounds;
        int lastIndex;
        List<TextView> list;
        if (backupViews.size() > tagDataList.size()) {
            list = CollectionsKt___CollectionsKt.toList(backupViews.subList(tagDataList.size(), backupViews.size()));
            for (TextView textView2 : list) {
                backupViews.remove(textView2);
                if (linearContainer != null) {
                    linearContainer.removeView(textView2);
                }
            }
        }
        int i3 = 0;
        for (Object obj : tagDataList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            TagData tagData = (TagData) obj;
            if (i3 >= 0) {
                lastIndex = CollectionsKt__CollectionsKt.getLastIndex(backupViews);
                if (i3 <= lastIndex) {
                    textView = backupViews.get(i3);
                    TextView textView3 = textView;
                    if (tagData.getText().length() <= 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        textView3.setText(tagData.getText());
                    } else {
                        textView3.setBackgroundResource(tagData.getRes());
                    }
                    if (tagData.getDrawableLeft() == 0) {
                        drawable = ContextCompat.getDrawable(getContext(), tagData.getDrawableLeft());
                    } else {
                        drawable = null;
                    }
                    if (drawable != null && (drawableLeftBounds = tagData.getDrawableLeftBounds()) != null) {
                        drawable.setBounds(drawableLeftBounds);
                    }
                    if (tagData.getDrawableRight() == 0) {
                        drawable2 = ContextCompat.getDrawable(getContext(), tagData.getDrawableRight());
                    } else {
                        drawable2 = null;
                    }
                    if (drawable2 != null && (drawableRightBounds = tagData.getDrawableRightBounds()) != null) {
                        drawable2.setBounds(drawableRightBounds);
                    }
                    textView3.setCompoundDrawables(drawable, null, drawable2, null);
                    textView3.setCompoundDrawablePadding(tagData.getDrawablePadding());
                    i3 = i16;
                }
            }
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            TextView a16 = a(context, tagData);
            backupViews.add(a16);
            textView = a16;
            if (linearContainer != null) {
                linearContainer.addView(a16);
                textView = a16;
            }
            TextView textView32 = textView;
            if (tagData.getText().length() <= 0) {
            }
            if (!z16) {
            }
            if (tagData.getDrawableLeft() == 0) {
            }
            if (drawable != null) {
                drawable.setBounds(drawableLeftBounds);
            }
            if (tagData.getDrawableRight() == 0) {
            }
            if (drawable2 != null) {
                drawable2.setBounds(drawableRightBounds);
            }
            textView32.setCompoundDrawables(drawable, null, drawable2, null);
            textView32.setCompoundDrawablePadding(tagData.getDrawablePadding());
            i3 = i16;
        }
    }

    public final void c(@NotNull List<TagData> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (TagData tagData : list) {
            if (tagData.getAlignTop()) {
                arrayList.add(tagData);
            } else {
                arrayList2.add(tagData);
            }
        }
        b(this.topLinearContainer, this.topViews, arrayList);
        b(this.bottomLinearContainer, this.bottomViews, arrayList2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TopTagViewContainerView(@NotNull Context mContext, @Nullable AttributeSet attributeSet) {
        this(mContext, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(mContext, "mContext");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TopTagViewContainerView(@NotNull Context mContext, @Nullable AttributeSet attributeSet, int i3) {
        super(mContext, attributeSet, i3);
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.f319532i = new LinkedHashMap();
        this.topViews = new ArrayList();
        this.bottomViews = new ArrayList();
        setOrientation(1);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        this.topLinearContainer = linearLayout;
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(0);
        this.bottomLinearContainer = linearLayout2;
        addView(this.topLinearContainer, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        addView(this.bottomLinearContainer, new LinearLayout.LayoutParams(-1, 0, 1.0f));
    }

    public /* synthetic */ TopTagViewContainerView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }
}
