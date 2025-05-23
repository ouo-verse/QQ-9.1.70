package com.tencent.mobileqq.webview.swift.utils;

import android.content.res.ColorStateList;
import android.util.SparseArray;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b&\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b4\u00105J\u001a\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0002R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0006R\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0006R\u0014\u0010\u0017\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0006R\u0014\u0010\u0019\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0006R\u0014\u0010\u001b\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0006R\u0014\u0010\u001d\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0006R\u0014\u0010\u001f\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0006R\u0014\u0010!\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u0006R\u0014\u0010#\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0006R\u0014\u0010%\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010\u0006R\u0014\u0010'\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010\u0006R\u0014\u0010)\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010\u0006R\u0014\u0010+\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010\u0006R\u0014\u0010-\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010\u0006R*\u00100\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R#\u00103\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00030\u00028F\u00a2\u0006\u0006\u001a\u0004\b1\u00102\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/webview/swift/utils/n;", "", "Landroid/util/SparseArray;", "Lkotlin/Pair;", "", "b", "I", "token_background_content_bg", "c", "token_icon_size", "d", "token_color_navIcon", "e", "token_color_content_text", "f", "token_color_navText", "Landroid/content/res/ColorStateList;", "g", "Landroid/content/res/ColorStateList;", "token_color_navText_values", tl.h.F, "token_icon_navLeftBack", "i", "token_icon_navLeftClose", "j", "token_icon_navMore", "k", "token_icon_navShare", "l", "token_icon_navEdit", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "token_icon_navDelete", DomainData.DOMAIN_NAME, "token_icon_navUpload", "o", "token_icon_navUser", "p", "token_icon_navSearch", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "token_icon_navTuning", "r", "token_icon_navQuestion_mark_circle", ReportConstant.COSTREPORT_PREFIX, "token_icon_navAdd_circle", "t", "browser_icon_with_token_color", "u", "Landroid/util/SparseArray;", "_token_icons_for_nav", "a", "()Landroid/util/SparseArray;", "tokenIconsForNav", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class n {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final n f314764a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static final int token_background_content_bg;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static final int token_icon_size;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static final int token_color_navIcon;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static final int token_color_content_text;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static final int token_color_navText;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static final ColorStateList token_color_navText_values;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static final int token_icon_navLeftBack;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static final int token_icon_navLeftClose;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static final int token_icon_navMore;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static final int token_icon_navShare;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static final int token_icon_navEdit;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static final int token_icon_navDelete;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static final int token_icon_navUpload;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static final int token_icon_navUser;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static final int token_icon_navSearch;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static final int token_icon_navTuning;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static final int token_icon_navQuestion_mark_circle;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static final int token_icon_navAdd_circle;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static final int browser_icon_with_token_color;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static SparseArray<Pair<Integer, Integer>> _token_icons_for_nav;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46147);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f314764a = new n();
        token_background_content_bg = R.drawable.qui_common_bg_bottom_standard_bg;
        token_icon_size = com.tencent.mobileqq.webview.view.b.e(24);
        token_color_navIcon = R.color.qui_common_icon_nav_secondary;
        token_color_content_text = R.color.qui_common_text_secondary;
        token_color_navText = R.color.qui_common_text_nav_secondary;
        token_color_navText_values = com.tencent.mobileqq.webview.view.b.h(R.color.qui_common_text_nav_secondary, "text_nav_secondary");
        token_icon_navLeftBack = R.drawable.qui_chevron_left_icon_nav_secondary;
        token_icon_navLeftClose = R.drawable.qui_close_icon_nav_secondary;
        token_icon_navMore = R.drawable.qui_more_icon_nav_secondary;
        token_icon_navShare = R.drawable.qui_share_icon_nav_secondary;
        token_icon_navEdit = R.drawable.qui_tiezi_icon_nav_secondary;
        token_icon_navDelete = R.drawable.qui_delete_icon_nav_secondary;
        token_icon_navUpload = R.drawable.qui_upload_icon_nav_secondary;
        token_icon_navUser = R.drawable.qui_user_icon_nav_secondary;
        token_icon_navSearch = R.drawable.qui_search_icon_nav_secondary;
        token_icon_navTuning = R.drawable.qui_tuning_icon_nav_secondary;
        token_icon_navQuestion_mark_circle = R.drawable.qui_question_mark_circle_icon_nav_secondary;
        token_icon_navAdd_circle = R.drawable.qui_add_circle_icon_nav_secondary;
        browser_icon_with_token_color = R.drawable.f160384je1;
    }

    n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final SparseArray<Pair<Integer, Integer>> b() {
        SparseArray<Pair<Integer, Integer>> sparseArray = new SparseArray<>();
        sparseArray.put(1, TuplesKt.to(Integer.valueOf(token_icon_navEdit), Integer.valueOf(R.string.bbm)));
        sparseArray.put(2, TuplesKt.to(Integer.valueOf(token_icon_navDelete), Integer.valueOf(R.string.bbl)));
        int i3 = token_icon_navMore;
        sparseArray.put(3, TuplesKt.to(Integer.valueOf(i3), Integer.valueOf(R.string.bbn)));
        sparseArray.put(4, TuplesKt.to(Integer.valueOf(token_icon_navShare), Integer.valueOf(R.string.bbp)));
        sparseArray.put(5, TuplesKt.to(Integer.valueOf(token_icon_navUpload), Integer.valueOf(R.string.bbr)));
        Integer valueOf = Integer.valueOf(token_icon_navAdd_circle);
        Integer valueOf2 = Integer.valueOf(R.string.f170028dd);
        sparseArray.put(7, TuplesKt.to(valueOf, valueOf2));
        int i16 = token_icon_navUser;
        sparseArray.put(8, TuplesKt.to(Integer.valueOf(i16), valueOf2));
        sparseArray.put(11, TuplesKt.to(Integer.valueOf(i16), valueOf2));
        int i17 = token_icon_navSearch;
        Integer valueOf3 = Integer.valueOf(i17);
        Integer valueOf4 = Integer.valueOf(R.string.bbo);
        sparseArray.put(9, TuplesKt.to(valueOf3, valueOf4));
        sparseArray.put(6, TuplesKt.to(Integer.valueOf(i17), valueOf4));
        sparseArray.put(10, TuplesKt.to(Integer.valueOf(i17), valueOf4));
        Integer valueOf5 = Integer.valueOf(token_icon_navTuning);
        Integer valueOf6 = Integer.valueOf(R.string.f1355601s);
        sparseArray.put(17, TuplesKt.to(valueOf5, valueOf6));
        sparseArray.put(19, TuplesKt.to(Integer.valueOf(token_icon_navQuestion_mark_circle), valueOf6));
        sparseArray.put(1002, TuplesKt.to(Integer.valueOf(i3), Integer.valueOf(R.string.hhb)));
        return sparseArray;
    }

    @NotNull
    public final SparseArray<Pair<Integer, Integer>> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SparseArray) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (_token_icons_for_nav == null) {
            _token_icons_for_nav = b();
        }
        SparseArray<Pair<Integer, Integer>> sparseArray = _token_icons_for_nav;
        Intrinsics.checkNotNull(sparseArray);
        return sparseArray;
    }
}
