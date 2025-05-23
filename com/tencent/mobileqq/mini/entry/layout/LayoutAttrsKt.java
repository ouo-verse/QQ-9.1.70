package com.tencent.mobileqq.mini.entry.layout;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.mini.entry.desktop.widget.DragRecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\u0010\u0004\n\u0002\b;\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010{\u001a\u00020|*\u00020\r2\u0018\u0010}\u001a\u0014\u0012\u0004\u0012\u00020|\u0012\u0004\u0012\u00020\u007f0~\u00a2\u0006\u0003\b\u0080\u0001H\u0086\b\u00f8\u0001\u0000\u001a.\u0010\u0081\u0001\u001a\u00030\u0082\u0001*\u00030\u0083\u00012\u0019\u0010}\u001a\u0015\u0012\u0005\u0012\u00030\u0082\u0001\u0012\u0004\u0012\u00020\u007f0~\u00a2\u0006\u0003\b\u0080\u0001H\u0086\b\u00f8\u0001\u0000\u001a-\u0010\u0081\u0001\u001a\u00030\u0082\u0001*\u00020\r2\u0019\u0010}\u001a\u0015\u0012\u0005\u0012\u00030\u0082\u0001\u0012\u0004\u0012\u00020\u007f0~\u00a2\u0006\u0003\b\u0080\u0001H\u0086\b\u00f8\u0001\u0000\u001a+\u0010\u0084\u0001\u001a\u00020s*\u00020\r2\u0018\u0010}\u001a\u0014\u0012\u0004\u0012\u00020s\u0012\u0004\u0012\u00020\u007f0~\u00a2\u0006\u0003\b\u0080\u0001H\u0086\b\u00f8\u0001\u0000\u001a,\u0010\u0085\u0001\u001a\u00020[*\u00030\u0083\u00012\u0018\u0010}\u001a\u0014\u0012\u0004\u0012\u00020[\u0012\u0004\u0012\u00020\u007f0~\u00a2\u0006\u0003\b\u0080\u0001H\u0086\b\u00f8\u0001\u0000\u001a+\u0010\u0085\u0001\u001a\u00020[*\u00020\r2\u0018\u0010}\u001a\u0014\u0012\u0004\u0012\u00020[\u0012\u0004\u0012\u00020\u007f0~\u00a2\u0006\u0003\b\u0080\u0001H\u0086\b\u00f8\u0001\u0000\u001a.\u0010\u0086\u0001\u001a\u00030\u0087\u0001*\u00030\u0083\u00012\u0019\u0010}\u001a\u0015\u0012\u0005\u0012\u00030\u0087\u0001\u0012\u0004\u0012\u00020\u007f0~\u00a2\u0006\u0003\b\u0080\u0001H\u0086\b\u00f8\u0001\u0000\u001a-\u0010\u0086\u0001\u001a\u00030\u0087\u0001*\u00020\r2\u0019\u0010}\u001a\u0015\u0012\u0005\u0012\u00030\u0087\u0001\u0012\u0004\u0012\u00020\u007f0~\u00a2\u0006\u0003\b\u0080\u0001H\u0086\b\u00f8\u0001\u0000\u001a+\u0010\u0088\u0001\u001a\u00020\u0016*\u00020\r2\u0018\u0010}\u001a\u0014\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u007f0~\u00a2\u0006\u0003\b\u0080\u0001H\u0086\b\u00f8\u0001\u0000\u001a+\u0010\u0089\u0001\u001a\u00020\u0006*\u00020\r2\u0018\u0010}\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u007f0~\u00a2\u0006\u0003\b\u0080\u0001H\u0086\b\u00f8\u0001\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"*\u0010\u0005\u001a\u00020\u0004*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00048\u00c6\u0002@\u00c6\u0002X\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\"*\u0010\f\u001a\u00020\u000b*\u00020\r2\u0006\u0010\u0003\u001a\u00020\u000b8\u00c6\u0002@\u00c6\u0002X\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\"*\u0010\u0012\u001a\u00020\u000b*\u00020\r2\u0006\u0010\u0003\u001a\u00020\u000b8\u00c6\u0002@\u00c6\u0002X\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011\".\u0010\u0015\u001a\u0004\u0018\u00010\u0004*\u00020\u00162\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u00c6\u0002@\u00c6\u0002X\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\"\u0015\u0010\u001b\u001a\u00020\u0001*\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d\"\u0015\u0010\u001b\u001a\u00020\u001e*\u00020\u001f8F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010 \"*\u0010!\u001a\u00020\u0001*\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00018\u00c6\u0002@\u00c7\u0002X\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\"*\u0010&\u001a\u00020\u0001*\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00018\u00c6\u0002@\u00c7\u0002X\u0086\u000e\u00a2\u0006\f\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%\"*\u0010)\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00018\u00c6\u0002@\u00c6\u0002X\u0086\u000e\u00a2\u0006\f\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-\"*\u0010.\u001a\u00020\u000b*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u000b8\u00c6\u0002@\u00c6\u0002X\u0086\u000e\u00a2\u0006\f\u001a\u0004\b/\u00100\"\u0004\b1\u00102\"*\u00103\u001a\u00020\u000b*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u000b8\u00c6\u0002@\u00c6\u0002X\u0086\u000e\u00a2\u0006\f\u001a\u0004\b4\u00100\"\u0004\b5\u00102\"*\u00106\u001a\u00020\u000b*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u000b8\u00c6\u0002@\u00c6\u0002X\u0086\u000e\u00a2\u0006\f\u001a\u0004\b7\u00100\"\u0004\b8\u00102\"*\u00109\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00018\u00c6\u0002@\u00c6\u0002X\u0086\u000e\u00a2\u0006\f\u001a\u0004\b:\u0010+\"\u0004\b;\u0010-\"*\u0010<\u001a\u00020\u000b*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u000b8\u00c6\u0002@\u00c6\u0002X\u0086\u000e\u00a2\u0006\f\u001a\u0004\b=\u00100\"\u0004\b>\u00102\"*\u0010?\u001a\u00020\u000b*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u000b8\u00c6\u0002@\u00c6\u0002X\u0086\u000e\u00a2\u0006\f\u001a\u0004\b@\u00100\"\u0004\bA\u00102\"*\u0010B\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00018\u00c6\u0002@\u00c6\u0002X\u0086\u000e\u00a2\u0006\f\u001a\u0004\bC\u0010+\"\u0004\bD\u0010-\"*\u0010E\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00018\u00c6\u0002@\u00c6\u0002X\u0086\u000e\u00a2\u0006\f\u001a\u0004\bF\u0010+\"\u0004\bG\u0010-\"*\u0010H\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00018\u00c6\u0002@\u00c6\u0002X\u0086\u000e\u00a2\u0006\f\u001a\u0004\bI\u0010+\"\u0004\bJ\u0010-\"*\u0010K\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00018\u00c6\u0002@\u00c6\u0002X\u0086\u000e\u00a2\u0006\f\u001a\u0004\bL\u0010+\"\u0004\bM\u0010-\"*\u0010N\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00018\u00c6\u0002@\u00c6\u0002X\u0086\u000e\u00a2\u0006\f\u001a\u0004\bO\u0010+\"\u0004\bP\u0010-\"*\u0010Q\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00018\u00c6\u0002@\u00c6\u0002X\u0086\u000e\u00a2\u0006\f\u001a\u0004\bR\u0010+\"\u0004\bS\u0010-\"*\u0010T\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00018\u00c6\u0002@\u00c6\u0002X\u0086\u000e\u00a2\u0006\f\u001a\u0004\bU\u0010+\"\u0004\bV\u0010-\"*\u0010W\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00018\u00c6\u0002@\u00c6\u0002X\u0086\u000e\u00a2\u0006\f\u001a\u0004\bX\u0010+\"\u0004\bY\u0010-\"*\u0010Z\u001a\u00020\u001e*\u00020[2\u0006\u0010\u0003\u001a\u00020\u001e8\u00c6\u0002@\u00c6\u0002X\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_\"*\u0010`\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00018\u00c6\u0002@\u00c6\u0002X\u0086\u000e\u00a2\u0006\f\u001a\u0004\ba\u0010+\"\u0004\bb\u0010-\"*\u0010c\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00018\u00c6\u0002@\u00c6\u0002X\u0086\u000e\u00a2\u0006\f\u001a\u0004\bd\u0010+\"\u0004\be\u0010-\"*\u0010f\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00018\u00c6\u0002@\u00c6\u0002X\u0086\u000e\u00a2\u0006\f\u001a\u0004\bg\u0010+\"\u0004\bh\u0010-\"*\u0010i\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00018\u00c6\u0002@\u00c6\u0002X\u0086\u000e\u00a2\u0006\f\u001a\u0004\bj\u0010+\"\u0004\bk\u0010-\"*\u0010l\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00018\u00c6\u0002@\u00c6\u0002X\u0086\u000e\u00a2\u0006\f\u001a\u0004\bm\u0010+\"\u0004\bn\u0010-\"\u0015\u0010o\u001a\u00020\u001e*\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\bp\u0010q\"*\u0010r\u001a\u00020\u0001*\u00020s2\u0006\u0010\u0003\u001a\u00020\u00018\u00c6\u0002@\u00c6\u0002X\u0086\u000e\u00a2\u0006\f\u001a\u0004\bt\u0010u\"\u0004\bv\u0010w\"*\u0010x\u001a\u00020\u0004*\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00048\u00c6\u0002@\u00c6\u0002X\u0086\u000e\u00a2\u0006\f\u001a\u0004\by\u0010\u0018\"\u0004\bz\u0010\u001a\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u008a\u0001"}, d2 = {"HORIZONTAL", "", "VERTICAL", "value", "", "_background", "Landroid/view/View;", "get_background", "(Landroid/view/View;)Ljava/lang/Object;", "set_background", "(Landroid/view/View;Ljava/lang/Object;)V", "", "_clipChildren", "Landroid/view/ViewGroup;", "get_clipChildren", "(Landroid/view/ViewGroup;)Z", "set_clipChildren", "(Landroid/view/ViewGroup;Z)V", "_clipPadding", "get_clipPadding", "set_clipPadding", "_text", "Landroid/widget/TextView;", "get_text", "(Landroid/widget/TextView;)Ljava/lang/Object;", "set_text", "(Landroid/widget/TextView;Ljava/lang/Object;)V", "dp", "getDp", "(I)I", "", "", "(Ljava/lang/Number;)F", "drawableLeft", "getDrawableLeft", "(Landroid/widget/TextView;)I", "setDrawableLeft", "(Landroid/widget/TextView;I)V", "drawablePadding", "getDrawablePadding", "setDrawablePadding", "layout_above", "getLayout_above", "(Landroid/view/View;)I", "setLayout_above", "(Landroid/view/View;I)V", "layout_alignParentLeft", "getLayout_alignParentLeft", "(Landroid/view/View;)Z", "setLayout_alignParentLeft", "(Landroid/view/View;Z)V", "layout_alignParentRight", "getLayout_alignParentRight", "setLayout_alignParentRight", "layout_alignParentTop", "getLayout_alignParentTop", "setLayout_alignParentTop", "layout_below", "getLayout_below", "setLayout_below", "layout_centerHorizontal", "getLayout_centerHorizontal", "setLayout_centerHorizontal", "layout_centerInParent", "getLayout_centerInParent", "setLayout_centerInParent", LayoutAttrDefine.Gravity.Layout_Gravity, "getLayout_gravity", "setLayout_gravity", "layout_height", "getLayout_height", "setLayout_height", "layout_marginBottom", "getLayout_marginBottom", "setLayout_marginBottom", "layout_marginLeft", "getLayout_marginLeft", "setLayout_marginLeft", "layout_marginRight", "getLayout_marginRight", "setLayout_marginRight", "layout_marginTop", "getLayout_marginTop", "setLayout_marginTop", "layout_toLeftOf", "getLayout_toLeftOf", "setLayout_toLeftOf", "layout_toRightOf", "getLayout_toRightOf", "setLayout_toRightOf", "layout_weight", "Landroid/widget/LinearLayout;", "getLayout_weight", "(Landroid/widget/LinearLayout;)F", "setLayout_weight", "(Landroid/widget/LinearLayout;F)V", "layout_width", "getLayout_width", "setLayout_width", LayoutAttrDefine.PADDING_BOTTOM, "getPadding_bottom", "setPadding_bottom", LayoutAttrDefine.PADDING_LEFT, "getPadding_left", "setPadding_left", LayoutAttrDefine.PADDING_RIGHT, "getPadding_right", "setPadding_right", LayoutAttrDefine.PADDING_TOP, "getPadding_top", "setPadding_top", "sp", "getSp", "(I)F", "src", "Landroid/widget/ImageView;", "getSrc", "(Landroid/widget/ImageView;)I", "setSrc", "(Landroid/widget/ImageView;I)V", "textColor", "getTextColor", "setTextColor", "DragRecyclerView", "Lcom/tencent/mobileqq/mini/entry/desktop/widget/DragRecyclerView;", "build", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", ParseCommon.FRAME_LAYOUT, "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "ImageView", ParseCommon.LINEAR_LAYOUT, ParseCommon.RELATIVE_LAYOUT, "Landroid/widget/RelativeLayout;", "TextView", "View", "AQQLiteModule_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class LayoutAttrsKt {
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;

    @NotNull
    public static final DragRecyclerView DragRecyclerView(@NotNull ViewGroup viewGroup, @NotNull Function1<? super DragRecyclerView, Unit> build) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        Intrinsics.checkNotNullParameter(build, "build");
        DragRecyclerView dragRecyclerView = new DragRecyclerView(viewGroup.getContext());
        dragRecyclerView.setTag(viewGroup);
        build.invoke(dragRecyclerView);
        viewGroup.addView(dragRecyclerView);
        return dragRecyclerView;
    }

    @NotNull
    public static final FrameLayout FrameLayout(@NotNull Context context, @NotNull Function1<? super FrameLayout, Unit> build) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(build, "build");
        FrameLayout frameLayout = new FrameLayout(context);
        build.invoke(frameLayout);
        return frameLayout;
    }

    @NotNull
    public static final ImageView ImageView(@NotNull ViewGroup viewGroup, @NotNull Function1<? super ImageView, Unit> build) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        Intrinsics.checkNotNullParameter(build, "build");
        ImageView imageView = new ImageView(viewGroup.getContext());
        imageView.setTag(viewGroup);
        build.invoke(imageView);
        viewGroup.addView(imageView);
        return imageView;
    }

    @NotNull
    public static final LinearLayout LinearLayout(@NotNull Context context, @NotNull Function1<? super LinearLayout, Unit> build) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(build, "build");
        LinearLayout linearLayout = new LinearLayout(context);
        build.invoke(linearLayout);
        return linearLayout;
    }

    @NotNull
    public static final RelativeLayout RelativeLayout(@NotNull Context context, @NotNull Function1<? super RelativeLayout, Unit> build) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(build, "build");
        RelativeLayout relativeLayout = new RelativeLayout(context);
        build.invoke(relativeLayout);
        return relativeLayout;
    }

    @NotNull
    public static final TextView TextView(@NotNull ViewGroup viewGroup, @NotNull Function1<? super TextView, Unit> build) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        Intrinsics.checkNotNullParameter(build, "build");
        TextView textView = new TextView(viewGroup.getContext());
        textView.setTag(viewGroup);
        build.invoke(textView);
        viewGroup.addView(textView);
        return textView;
    }

    @NotNull
    public static final View View(@NotNull ViewGroup viewGroup, @NotNull Function1<? super View, Unit> build) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        Intrinsics.checkNotNullParameter(build, "build");
        View view = new View(viewGroup.getContext());
        view.setTag(viewGroup);
        build.invoke(view);
        viewGroup.addView(view);
        return view;
    }

    public static final int getDp(int i3) {
        return (int) TypedValue.applyDimension(1, i3, Resources.getSystem().getDisplayMetrics());
    }

    public static final int getDrawableLeft(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        return 0;
    }

    public static final int getDrawablePadding(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        return 0;
    }

    public static final int getLayout_above(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return 0;
    }

    public static final boolean getLayout_alignParentLeft(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return false;
    }

    public static final boolean getLayout_alignParentRight(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return false;
    }

    public static final boolean getLayout_alignParentTop(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return false;
    }

    public static final int getLayout_below(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return 0;
    }

    public static final boolean getLayout_centerHorizontal(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return false;
    }

    public static final boolean getLayout_centerInParent(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return false;
    }

    public static final int getLayout_gravity(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return 0;
    }

    public static final int getLayout_height(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return 0;
    }

    public static final int getLayout_marginBottom(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return 0;
    }

    public static final int getLayout_marginLeft(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return 0;
    }

    public static final int getLayout_marginRight(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return 0;
    }

    public static final int getLayout_marginTop(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return 0;
    }

    public static final int getLayout_toLeftOf(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return 0;
    }

    public static final int getLayout_toRightOf(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return 0;
    }

    public static final float getLayout_weight(@NotNull LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<this>");
        return 1.0f;
    }

    public static final int getLayout_width(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return view.getLayoutParams().width;
    }

    public static final int getPadding_bottom(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return view.getPaddingBottom();
    }

    public static final int getPadding_left(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return view.getPaddingLeft();
    }

    public static final int getPadding_right(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return view.getPaddingRight();
    }

    public static final int getPadding_top(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return view.getPaddingTop();
    }

    public static final float getSp(int i3) {
        return TypedValue.applyDimension(2, i3, Resources.getSystem().getDisplayMetrics());
    }

    public static final int getSrc(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        return -1;
    }

    @NotNull
    public static final Object getTextColor(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        return "";
    }

    @NotNull
    public static final Object get_background(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return "";
    }

    public static final boolean get_clipChildren(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        return true;
    }

    public static final boolean get_clipPadding(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        return false;
    }

    @Nullable
    public static final Object get_text(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        CharSequence text = textView.getText();
        if (text != null) {
            return text.toString();
        }
        return null;
    }

    @RequiresApi(21)
    public static final void setDrawableLeft(@NotNull TextView textView, int i3) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        textView.setCompoundDrawables(textView.getContext().getDrawable(i3), null, null, null);
    }

    @RequiresApi(21)
    public static final void setDrawablePadding(@NotNull TextView textView, int i3) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        textView.setCompoundDrawablePadding(getDp(i3));
    }

    public static final void setLayout_above(@NotNull View view, int i3) {
        int width;
        int height;
        RelativeLayout.LayoutParams layoutParams;
        int[] rules;
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 != null) {
            width = layoutParams2.width;
        } else {
            width = view.getWidth();
        }
        ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
        if (layoutParams3 != null) {
            height = layoutParams3.height;
        } else {
            height = view.getHeight();
        }
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(width, height);
        ViewGroup.LayoutParams layoutParams5 = view.getLayoutParams();
        if (layoutParams5 instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) layoutParams5;
        } else {
            layoutParams = null;
        }
        if (layoutParams != null && (rules = layoutParams.getRules()) != null) {
            Intrinsics.checkNotNullExpressionValue(rules, "rules");
            int length = rules.length;
            int i16 = 0;
            int i17 = 0;
            while (i16 < length) {
                layoutParams4.addRule(i17, rules[i16]);
                i16++;
                i17++;
            }
        }
        layoutParams4.addRule(2, i3);
        view.setLayoutParams(layoutParams4);
    }

    public static final void setLayout_alignParentLeft(@NotNull View view, boolean z16) {
        int width;
        int height;
        RelativeLayout.LayoutParams layoutParams;
        int[] rules;
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (!z16) {
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 != null) {
            width = layoutParams2.width;
        } else {
            width = view.getWidth();
        }
        ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
        if (layoutParams3 != null) {
            height = layoutParams3.height;
        } else {
            height = view.getHeight();
        }
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(width, height);
        ViewGroup.LayoutParams layoutParams5 = view.getLayoutParams();
        if (layoutParams5 instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) layoutParams5;
        } else {
            layoutParams = null;
        }
        if (layoutParams != null && (rules = layoutParams.getRules()) != null) {
            Intrinsics.checkNotNullExpressionValue(rules, "rules");
            int length = rules.length;
            int i3 = 0;
            int i16 = 0;
            while (i3 < length) {
                layoutParams4.addRule(i16, rules[i3]);
                i3++;
                i16++;
            }
        }
        layoutParams4.addRule(9, -1);
        view.setLayoutParams(layoutParams4);
    }

    public static final void setLayout_alignParentRight(@NotNull View view, boolean z16) {
        int width;
        int height;
        RelativeLayout.LayoutParams layoutParams;
        int[] rules;
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (!z16) {
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 != null) {
            width = layoutParams2.width;
        } else {
            width = view.getWidth();
        }
        ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
        if (layoutParams3 != null) {
            height = layoutParams3.height;
        } else {
            height = view.getHeight();
        }
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(width, height);
        ViewGroup.LayoutParams layoutParams5 = view.getLayoutParams();
        if (layoutParams5 instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) layoutParams5;
        } else {
            layoutParams = null;
        }
        if (layoutParams != null && (rules = layoutParams.getRules()) != null) {
            Intrinsics.checkNotNullExpressionValue(rules, "rules");
            int length = rules.length;
            int i3 = 0;
            int i16 = 0;
            while (i3 < length) {
                layoutParams4.addRule(i16, rules[i3]);
                i3++;
                i16++;
            }
        }
        layoutParams4.addRule(11, -1);
        view.setLayoutParams(layoutParams4);
    }

    public static final void setLayout_alignParentTop(@NotNull View view, boolean z16) {
        int width;
        int height;
        RelativeLayout.LayoutParams layoutParams;
        int[] rules;
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (!z16) {
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 != null) {
            width = layoutParams2.width;
        } else {
            width = view.getWidth();
        }
        ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
        if (layoutParams3 != null) {
            height = layoutParams3.height;
        } else {
            height = view.getHeight();
        }
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(width, height);
        ViewGroup.LayoutParams layoutParams5 = view.getLayoutParams();
        if (layoutParams5 instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) layoutParams5;
        } else {
            layoutParams = null;
        }
        if (layoutParams != null && (rules = layoutParams.getRules()) != null) {
            Intrinsics.checkNotNullExpressionValue(rules, "rules");
            int length = rules.length;
            int i3 = 0;
            int i16 = 0;
            while (i3 < length) {
                layoutParams4.addRule(i16, rules[i3]);
                i3++;
                i16++;
            }
        }
        layoutParams4.addRule(9, -1);
        view.setLayoutParams(layoutParams4);
    }

    public static final void setLayout_below(@NotNull View view, int i3) {
        int width;
        int height;
        RelativeLayout.LayoutParams layoutParams;
        int[] rules;
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 != null) {
            width = layoutParams2.width;
        } else {
            width = view.getWidth();
        }
        ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
        if (layoutParams3 != null) {
            height = layoutParams3.height;
        } else {
            height = view.getHeight();
        }
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(width, height);
        ViewGroup.LayoutParams layoutParams5 = view.getLayoutParams();
        if (layoutParams5 instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) layoutParams5;
        } else {
            layoutParams = null;
        }
        if (layoutParams != null && (rules = layoutParams.getRules()) != null) {
            Intrinsics.checkNotNullExpressionValue(rules, "rules");
            int length = rules.length;
            int i16 = 0;
            int i17 = 0;
            while (i16 < length) {
                layoutParams4.addRule(i17, rules[i16]);
                i16++;
                i17++;
            }
        }
        layoutParams4.addRule(3, i3);
        view.setLayoutParams(layoutParams4);
    }

    public static final void setLayout_centerHorizontal(@NotNull View view, boolean z16) {
        int width;
        int height;
        RelativeLayout.LayoutParams layoutParams;
        int[] rules;
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (!z16) {
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 != null) {
            width = layoutParams2.width;
        } else {
            width = view.getWidth();
        }
        ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
        if (layoutParams3 != null) {
            height = layoutParams3.height;
        } else {
            height = view.getHeight();
        }
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(width, height);
        ViewGroup.LayoutParams layoutParams5 = view.getLayoutParams();
        if (layoutParams5 instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) layoutParams5;
        } else {
            layoutParams = null;
        }
        if (layoutParams != null && (rules = layoutParams.getRules()) != null) {
            Intrinsics.checkNotNullExpressionValue(rules, "rules");
            int length = rules.length;
            int i3 = 0;
            int i16 = 0;
            while (i3 < length) {
                layoutParams4.addRule(i16, rules[i3]);
                i3++;
                i16++;
            }
        }
        layoutParams4.addRule(14, -1);
        view.setLayoutParams(layoutParams4);
    }

    public static final void setLayout_centerInParent(@NotNull View view, boolean z16) {
        int width;
        int height;
        RelativeLayout.LayoutParams layoutParams;
        int[] rules;
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (!z16) {
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 != null) {
            width = layoutParams2.width;
        } else {
            width = view.getWidth();
        }
        ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
        if (layoutParams3 != null) {
            height = layoutParams3.height;
        } else {
            height = view.getHeight();
        }
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(width, height);
        ViewGroup.LayoutParams layoutParams5 = view.getLayoutParams();
        if (layoutParams5 instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) layoutParams5;
        } else {
            layoutParams = null;
        }
        if (layoutParams != null && (rules = layoutParams.getRules()) != null) {
            Intrinsics.checkNotNullExpressionValue(rules, "rules");
            int length = rules.length;
            int i3 = 0;
            int i16 = 0;
            while (i3 < length) {
                layoutParams4.addRule(i16, rules[i3]);
                i3++;
                i16++;
            }
        }
        layoutParams4.addRule(13, -1);
        view.setLayoutParams(layoutParams4);
    }

    public static final void setLayout_gravity(@NotNull View view, int i3) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Object tag = view.getTag();
        if (tag instanceof FrameLayout) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
            layoutParams2.gravity = i3;
            view.setLayoutParams(layoutParams2);
            return;
        }
        if (tag instanceof LinearLayout) {
            ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams) layoutParams3);
            layoutParams4.gravity = i3;
            view.setLayoutParams(layoutParams4);
        }
    }

    public static final void setLayout_height(@NotNull View view, int i3) {
        int i16;
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            i16 = layoutParams.width;
        } else {
            i16 = 0;
        }
        if (i3 > 0) {
            i3 = getDp(i3);
        }
        if (view.getLayoutParams() != null) {
            view.getLayoutParams().width = i16;
            view.getLayoutParams().height = i3;
        } else {
            view.setLayoutParams(new ViewGroup.MarginLayoutParams(i16, i3));
        }
    }

    public static final void setLayout_marginBottom(@NotNull View view, int i3) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            marginLayoutParams.bottomMargin = getDp(i3);
        }
    }

    public static final void setLayout_marginLeft(@NotNull View view, int i3) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            marginLayoutParams.leftMargin = getDp(i3);
        }
    }

    public static final void setLayout_marginRight(@NotNull View view, int i3) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            marginLayoutParams.rightMargin = getDp(i3);
        }
    }

    public static final void setLayout_marginTop(@NotNull View view, int i3) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = getDp(i3);
        }
    }

    public static final void setLayout_toLeftOf(@NotNull View view, int i3) {
        int width;
        int height;
        RelativeLayout.LayoutParams layoutParams;
        int[] rules;
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 != null) {
            width = layoutParams2.width;
        } else {
            width = view.getWidth();
        }
        ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
        if (layoutParams3 != null) {
            height = layoutParams3.height;
        } else {
            height = view.getHeight();
        }
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(width, height);
        ViewGroup.LayoutParams layoutParams5 = view.getLayoutParams();
        if (layoutParams5 instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) layoutParams5;
        } else {
            layoutParams = null;
        }
        if (layoutParams != null && (rules = layoutParams.getRules()) != null) {
            Intrinsics.checkNotNullExpressionValue(rules, "rules");
            int length = rules.length;
            int i16 = 0;
            int i17 = 0;
            while (i16 < length) {
                layoutParams4.addRule(i17, rules[i16]);
                i16++;
                i17++;
            }
        }
        layoutParams4.addRule(0, i3);
        view.setLayoutParams(layoutParams4);
    }

    public static final void setLayout_toRightOf(@NotNull View view, int i3) {
        int width;
        int height;
        RelativeLayout.LayoutParams layoutParams;
        int[] rules;
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 != null) {
            width = layoutParams2.width;
        } else {
            width = view.getWidth();
        }
        ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
        if (layoutParams3 != null) {
            height = layoutParams3.height;
        } else {
            height = view.getHeight();
        }
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(width, height);
        ViewGroup.LayoutParams layoutParams5 = view.getLayoutParams();
        if (layoutParams5 instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) layoutParams5;
        } else {
            layoutParams = null;
        }
        if (layoutParams != null && (rules = layoutParams.getRules()) != null) {
            Intrinsics.checkNotNullExpressionValue(rules, "rules");
            int length = rules.length;
            int i16 = 0;
            int i17 = 0;
            while (i16 < length) {
                layoutParams4.addRule(i17, rules[i16]);
                i16++;
                i17++;
            }
        }
        layoutParams4.addRule(1, i3);
        view.setLayoutParams(layoutParams4);
    }

    public static final void setLayout_weight(@NotNull LinearLayout linearLayout, float f16) {
        int width;
        int height;
        LinearLayout.LayoutParams layoutParams;
        int i3;
        Intrinsics.checkNotNullParameter(linearLayout, "<this>");
        ViewGroup.LayoutParams layoutParams2 = linearLayout.getLayoutParams();
        if (layoutParams2 != null) {
            width = layoutParams2.width;
        } else {
            width = linearLayout.getWidth();
        }
        ViewGroup.LayoutParams layoutParams3 = linearLayout.getLayoutParams();
        if (layoutParams3 != null) {
            height = layoutParams3.height;
        } else {
            height = linearLayout.getHeight();
        }
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(width, height, f16);
        ViewGroup.LayoutParams layoutParams5 = linearLayout.getLayoutParams();
        if (layoutParams5 instanceof LinearLayout.LayoutParams) {
            layoutParams = (LinearLayout.LayoutParams) layoutParams5;
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            i3 = layoutParams.gravity;
        } else {
            i3 = -1;
        }
        layoutParams4.gravity = i3;
        linearLayout.setLayoutParams(layoutParams4);
    }

    public static final void setLayout_width(@NotNull View view, int i3) {
        int i16;
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (i3 > 0) {
            i3 = getDp(i3);
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            i16 = layoutParams.height;
        } else {
            i16 = 0;
        }
        if (view.getLayoutParams() != null) {
            view.getLayoutParams().width = i3;
            view.getLayoutParams().height = i16;
        } else {
            view.setLayoutParams(new ViewGroup.MarginLayoutParams(i3, i16));
        }
    }

    public static final void setPadding_bottom(@NotNull View view, int i3) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), getDp(i3));
    }

    public static final void setPadding_left(@NotNull View view, int i3) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setPadding(getDp(i3), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
    }

    public static final void setPadding_right(@NotNull View view, int i3) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), getDp(i3), view.getPaddingBottom());
    }

    public static final void setPadding_top(@NotNull View view, int i3) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setPadding(view.getPaddingLeft(), getDp(i3), view.getPaddingRight(), view.getPaddingBottom());
    }

    public static final void setSrc(@NotNull ImageView imageView, int i3) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        imageView.setImageResource(i3);
    }

    public static final void setTextColor(@NotNull TextView textView, @NotNull Object value) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        if (value instanceof Integer) {
            textView.setTextColor(textView.getResources().getColorStateList(((Number) value).intValue()));
        } else if (value instanceof String) {
            textView.setTextColor(Color.parseColor((String) value));
        }
    }

    public static final void set_background(@NotNull View view, @NotNull Object value) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        if (value instanceof String) {
            view.setBackgroundColor(Color.parseColor((String) value));
        } else if (value instanceof Integer) {
            view.setBackgroundResource(((Number) value).intValue());
        }
    }

    public static final void set_clipChildren(@NotNull ViewGroup viewGroup, boolean z16) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        viewGroup.setClipChildren(z16);
    }

    public static final void set_clipPadding(@NotNull ViewGroup viewGroup, boolean z16) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        viewGroup.setClipToPadding(z16);
    }

    public static final void set_text(@NotNull TextView textView, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        if (obj instanceof Integer) {
            textView.setText(((Number) obj).intValue());
        } else if (obj instanceof String) {
            textView.setText((CharSequence) obj);
        }
    }

    @NotNull
    public static final FrameLayout FrameLayout(@NotNull ViewGroup viewGroup, @NotNull Function1<? super FrameLayout, Unit> build) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        Intrinsics.checkNotNullParameter(build, "build");
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setTag(viewGroup);
        build.invoke(frameLayout);
        viewGroup.addView(frameLayout);
        return frameLayout;
    }

    @NotNull
    public static final LinearLayout LinearLayout(@NotNull ViewGroup viewGroup, @NotNull Function1<? super LinearLayout, Unit> build) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        Intrinsics.checkNotNullParameter(build, "build");
        LinearLayout linearLayout = new LinearLayout(viewGroup.getContext());
        linearLayout.setTag(viewGroup);
        build.invoke(linearLayout);
        viewGroup.addView(linearLayout);
        return linearLayout;
    }

    @NotNull
    public static final RelativeLayout RelativeLayout(@NotNull ViewGroup viewGroup, @NotNull Function1<? super RelativeLayout, Unit> build) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        Intrinsics.checkNotNullParameter(build, "build");
        RelativeLayout relativeLayout = new RelativeLayout(viewGroup.getContext());
        relativeLayout.setTag(viewGroup);
        build.invoke(relativeLayout);
        viewGroup.addView(relativeLayout);
        return relativeLayout;
    }

    public static final float getDp(@NotNull Number number) {
        Intrinsics.checkNotNullParameter(number, "<this>");
        return TypedValue.applyDimension(1, ((Float) number).floatValue(), Resources.getSystem().getDisplayMetrics());
    }
}
