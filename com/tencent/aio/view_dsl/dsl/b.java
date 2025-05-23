package com.tencent.aio.view_dsl.dsl;

import android.R;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0010\b\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\bC\n\u0002\u0018\u0002\n\u0002\bJ\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0005\"\u001a\u0010\u0005\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004\"\u001a\u0010\b\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0002\u001a\u0004\b\u0007\u0010\u0004\"\u001a\u0010\n\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\t\u0010\u0002\u001a\u0004\b\t\u0010\u0004\"\u001a\u0010\r\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0002\u001a\u0004\b\f\u0010\u0004\"\u001a\u0010\u0010\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0002\u001a\u0004\b\u000f\u0010\u0004\"\u001a\u0010\u0013\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0002\u001a\u0004\b\u0012\u0010\u0004\"\u001a\u0010\u0016\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0002\u001a\u0004\b\u0015\u0010\u0004\"\u001a\u0010\u0018\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0002\u001a\u0004\b\u0001\u0010\u0004\"\u001a\u0010\u001b\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0002\u001a\u0004\b\u001a\u0010\u0004\"\u001a\u0010\u001e\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0002\u001a\u0004\b\u001d\u0010\u0004\"\u001a\u0010!\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0002\u001a\u0004\b \u0010\u0004\"\u001a\u0010\"\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0002\u001a\u0004\b\u000e\u0010\u0004\"\u001a\u0010$\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\f\n\u0004\b#\u0010\u0002\u001a\u0004\b\u0019\u0010\u0004\"\u001a\u0010%\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0002\u001a\u0004\b\u001c\u0010\u0004\"\u001a\u0010&\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\f\u0010\u0002\u001a\u0004\b\u000b\u0010\u0004\"\u001a\u0010'\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0002\u001a\u0004\b\u001f\u0010\u0004\"\u001a\u0010)\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\f\n\u0004\b(\u0010\u0002\u001a\u0004\b\u0011\u0010\u0004\"\u001a\u0010+\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\f\n\u0004\b*\u0010\u0002\u001a\u0004\b\u0014\u0010\u0004\"\u001a\u0010-\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\f\n\u0004\b,\u0010\u0002\u001a\u0004\b\u0017\u0010\u0004\"\u0017\u00103\u001a\u00020.8\u0006\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0017\u00106\u001a\u00020.8\u0006\u00a2\u0006\f\n\u0004\b4\u00100\u001a\u0004\b5\u00102\"\u0017\u00109\u001a\u00020.8\u0006\u00a2\u0006\f\n\u0004\b7\u00100\u001a\u0004\b8\u00102\"\u0017\u0010<\u001a\u00020.8\u0006\u00a2\u0006\f\n\u0004\b:\u00100\u001a\u0004\b;\u00102\"\u0017\u0010?\u001a\u00020.8\u0006\u00a2\u0006\f\n\u0004\b=\u00100\u001a\u0004\b>\u00102\"\u0017\u0010B\u001a\u00020.8\u0006\u00a2\u0006\f\n\u0004\b@\u00100\u001a\u0004\bA\u00102\"\u0017\u0010E\u001a\u00020.8\u0006\u00a2\u0006\f\n\u0004\bC\u00100\u001a\u0004\bD\u00102\"\u0017\u0010H\u001a\u00020.8\u0006\u00a2\u0006\f\n\u0004\bF\u00100\u001a\u0004\bG\u00102\"\u001a\u0010K\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\f\n\u0004\bI\u0010\u0002\u001a\u0004\bJ\u0010\u0004\"\u001a\u0010N\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\f\n\u0004\bL\u0010\u0002\u001a\u0004\bM\u0010\u0004\"\u001a\u0010Q\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\f\n\u0004\bO\u0010\u0002\u001a\u0004\bP\u0010\u0004\"\u001a\u0010T\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\f\n\u0004\bR\u0010\u0002\u001a\u0004\bS\u0010\u0004\"\u001a\u0010W\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\f\n\u0004\bU\u0010\u0002\u001a\u0004\bV\u0010\u0004\"\u001a\u0010Z\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\f\n\u0004\bX\u0010\u0002\u001a\u0004\bY\u0010\u0004\"\u001a\u0010]\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\f\n\u0004\b[\u0010\u0002\u001a\u0004\b\\\u0010\u0004\"\u001a\u0010_\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0002\u0010\u0002\u001a\u0004\b^\u0010\u0004\"\u001a\u0010b\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\f\n\u0004\b`\u0010\u0002\u001a\u0004\ba\u0010\u0004\"\u001a\u0010e\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\f\n\u0004\bc\u0010\u0002\u001a\u0004\bd\u0010\u0004\"\u001a\u0010h\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\f\n\u0004\bf\u0010\u0002\u001a\u0004\bg\u0010\u0004\"\u001a\u0010k\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\f\n\u0004\bi\u0010\u0002\u001a\u0004\bj\u0010\u0004\"\u001a\u0010n\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\f\n\u0004\bl\u0010\u0002\u001a\u0004\bm\u0010\u0004\"\u001a\u0010q\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\f\n\u0004\bo\u0010\u0002\u001a\u0004\bp\u0010\u0004\"\u0017\u0010w\u001a\u00020r8\u0006\u00a2\u0006\f\n\u0004\bs\u0010t\u001a\u0004\bu\u0010v\"\u0017\u0010z\u001a\u00020r8\u0006\u00a2\u0006\f\n\u0004\bx\u0010t\u001a\u0004\by\u0010v\"\u0017\u0010}\u001a\u00020r8\u0006\u00a2\u0006\f\n\u0004\b{\u0010t\u001a\u0004\b|\u0010v\"\u0018\u0010\u0080\u0001\u001a\u00020r8\u0006\u00a2\u0006\f\n\u0004\b~\u0010t\u001a\u0004\b\u007f\u0010v\"\u001a\u0010\u0083\u0001\u001a\u00020r8\u0006\u00a2\u0006\u000e\n\u0005\b\u0081\u0001\u0010t\u001a\u0005\b\u0082\u0001\u0010v\"\u001a\u0010\u0086\u0001\u001a\u00020r8\u0006\u00a2\u0006\u000e\n\u0005\b\u0084\u0001\u0010t\u001a\u0005\b\u0085\u0001\u0010v\"\u001a\u0010\u0089\u0001\u001a\u00020r8\u0006\u00a2\u0006\u000e\n\u0005\b\u0087\u0001\u0010t\u001a\u0005\b\u0088\u0001\u0010v\"\u001a\u0010\u008c\u0001\u001a\u00020r8\u0006\u00a2\u0006\u000e\n\u0005\b\u008a\u0001\u0010t\u001a\u0005\b\u008b\u0001\u0010v\"\u001d\u0010\u008f\u0001\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\u000e\n\u0005\b\u008d\u0001\u0010\u0002\u001a\u0005\b\u008e\u0001\u0010\u0004\"\u001d\u0010\u0092\u0001\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\u000e\n\u0005\b\u0090\u0001\u0010\u0002\u001a\u0005\b\u0091\u0001\u0010\u0004\"\u001d\u0010\u0095\u0001\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\u000e\n\u0005\b\u0093\u0001\u0010\u0002\u001a\u0005\b\u0094\u0001\u0010\u0004\"\u001d\u0010\u0098\u0001\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\u000e\n\u0005\b\u0096\u0001\u0010\u0002\u001a\u0005\b\u0097\u0001\u0010\u0004\"\u001d\u0010\u009b\u0001\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\u000e\n\u0005\b\u0099\u0001\u0010\u0002\u001a\u0005\b\u009a\u0001\u0010\u0004\"\u001d\u0010\u009e\u0001\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\u000e\n\u0005\b\u009c\u0001\u0010\u0002\u001a\u0005\b\u009d\u0001\u0010\u0004\"\u001d\u0010\u00a1\u0001\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\u000e\n\u0005\b\u009f\u0001\u0010\u0002\u001a\u0005\b\u00a0\u0001\u0010\u0004\"\u001d\u0010\u00a4\u0001\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\u000e\n\u0005\b\u00a2\u0001\u0010\u0002\u001a\u0005\b\u00a3\u0001\u0010\u0004\"\u001d\u0010\u00a7\u0001\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\u000e\n\u0005\b\u00a5\u0001\u0010\u0002\u001a\u0005\b\u00a6\u0001\u0010\u0004\"\u001d\u0010\u00aa\u0001\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\u000e\n\u0005\b\u00a8\u0001\u0010\u0002\u001a\u0005\b\u00a9\u0001\u0010\u0004\"\u001d\u0010\u00ad\u0001\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\u000e\n\u0005\b\u00ab\u0001\u0010\u0002\u001a\u0005\b\u00ac\u0001\u0010\u0004\"\u001d\u0010\u00b0\u0001\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\u000e\n\u0005\b\u00ae\u0001\u0010\u0002\u001a\u0005\b\u00af\u0001\u0010\u0004\"\u001d\u0010\u00b3\u0001\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\u000e\n\u0005\b\u00b1\u0001\u0010\u0002\u001a\u0005\b\u00b2\u0001\u0010\u0004\"\u001d\u0010\u00b6\u0001\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\u000e\n\u0005\b\u00b4\u0001\u0010\u0002\u001a\u0005\b\u00b5\u0001\u0010\u0004\"\u001d\u0010\u00b9\u0001\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\u000e\n\u0005\b\u00b7\u0001\u0010\u0002\u001a\u0005\b\u00b8\u0001\u0010\u0004\"\u001d\u0010\u00bc\u0001\u001a\u00020\u00008\u0006X\u0086D\u00a2\u0006\u000e\n\u0005\b\u00ba\u0001\u0010\u0002\u001a\u0005\b\u00bb\u0001\u0010\u0004\"\u001c\u0010\u00c1\u0001\u001a\u00030\u00bd\u00018\u0006\u00a2\u0006\u000f\n\u0006\b\u00be\u0001\u0010\u00bf\u0001\u001a\u0005\b\u0006\u0010\u00c0\u0001\"\u001d\u0010\u00c4\u0001\u001a\u00030\u00bd\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00c2\u0001\u0010\u00bf\u0001\u001a\u0006\b\u00c3\u0001\u0010\u00c0\u0001\"\u001d\u0010\u00c7\u0001\u001a\u00030\u00bd\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00c5\u0001\u0010\u00bf\u0001\u001a\u0006\b\u00c6\u0001\u0010\u00c0\u0001\"\u001d\u0010\u00ca\u0001\u001a\u00030\u00bd\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00c8\u0001\u0010\u00bf\u0001\u001a\u0006\b\u00c9\u0001\u0010\u00c0\u0001\"\u001f\u0010\u00cf\u0001\u001a\u00030\u00cb\u00018\u0006X\u0086D\u00a2\u0006\u000f\n\u0006\b\u00cc\u0001\u0010\u00cd\u0001\u001a\u0005\b#\u0010\u00ce\u0001\u00a8\u0006\u00d0\u0001"}, d2 = {"", "a", "I", "l", "()I", ParseCommon.LAYOUT_PARAMS_MATCH_PARENT, "b", "p", ParseCommon.LAYOUT_PARAMS_WRAP_CONTENT, "c", "fill_parent", "d", "o", NodeProps.VISIBLE, "e", "getGone", "gone", "f", "getInvisible", QZoneJsConstants.DYNAMIC_ALBUM_INVISIBLE, "g", DomainData.DOMAIN_NAME, "vertical", h.F, "bold", "i", "getItalic", "italic", "j", "getBold_italic", "bold_italic", "k", "getGravity_start", "gravity_start", "gravity_center", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "gravity_left", "gravity_right", "gravity_bottom", "gravity_top", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "gravity_center_horizontal", "r", "gravity_center_vertical", ReportConstant.COSTREPORT_PREFIX, "gravity_end", "Landroid/widget/ImageView$ScaleType;", "t", "Landroid/widget/ImageView$ScaleType;", "getScale_fit_xy", "()Landroid/widget/ImageView$ScaleType;", "scale_fit_xy", "u", "getScale_center_crop", "scale_center_crop", "v", "getScale_center", "scale_center", "w", "getScale_center_inside", "scale_center_inside", HippyTKDListViewAdapter.X, "getScale_fit_center", "scale_fit_center", "y", "getScale_fit_end", "scale_fit_end", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "getScale_matrix", "scale_matrix", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "getScale_fit_start", "scale_fit_start", "B", "getConstraint_start", "constraint_start", BdhLogUtil.LogTag.Tag_Conn, "getConstraint_end", "constraint_end", "D", "getConstraint_top", "constraint_top", "E", "getConstraint_bottom", "constraint_bottom", UserInfo.SEX_FEMALE, "getConstraint_baseline", "constraint_baseline", "G", "getPacked", "packed", "H", "getSpread_inside", "spread_inside", "getBarrier_top", "barrier_top", "J", "getBarrier_right", "barrier_right", "K", "getBarrier_bottom", "barrier_bottom", "L", "getBarrier_start", "barrier_start", "M", "getBarrier_end", "barrier_end", "N", "getWrap_chain", "wrap_chain", "O", "getWrap_aligned", "wrap_aligned", "Landroid/graphics/drawable/GradientDrawable$Orientation;", "P", "Landroid/graphics/drawable/GradientDrawable$Orientation;", "getGradient_top_bottom", "()Landroid/graphics/drawable/GradientDrawable$Orientation;", "gradient_top_bottom", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "getGradient_tr_bl", "gradient_tr_bl", BdhLogUtil.LogTag.Tag_Req, "getGradient_right_left", "gradient_right_left", ExifInterface.LATITUDE_SOUTH, "getGradient_br_tl", "gradient_br_tl", "T", "getGradient_bottom_top", "gradient_bottom_top", "U", "getGradient_bl_tr", "gradient_bl_tr", "V", "getGradient_left_right", "gradient_left_right", "W", "getGradient_tl_br", "gradient_tl_br", "X", "getShape_oval", "shape_oval", "Y", "getShape_line", "shape_line", "Z", "getShape_ring", "shape_ring", "a0", "getGradient_type_radial", "gradient_type_radial", "b0", "getGradient_type_sweep", "gradient_type_sweep", "c0", "getState_enable", "state_enable", "d0", "getState_disable", "state_disable", "e0", "getState_pressed", "state_pressed", "f0", "getState_unpressed", "state_unpressed", "g0", "getState_focused", "state_focused", "h0", "getState_unfocused", "state_unfocused", "i0", "getState_selected", "state_selected", "j0", "getState_unselected", "state_unselected", "k0", "getInput_type_number", "input_type_number", "l0", "getWrap_mode_chain", "wrap_mode_chain", "m0", "getWrap_mode_aligned", "wrap_mode_aligned", "Landroid/text/TextUtils$TruncateAt;", "n0", "Landroid/text/TextUtils$TruncateAt;", "()Landroid/text/TextUtils$TruncateAt;", "ellipsize_end", "o0", "getEllipsize_marquee", "ellipsize_marquee", "p0", "getEllipsize_middle", "ellipsize_middle", "q0", "getEllipsize_start", "ellipsize_start", "", "r0", "Ljava/lang/String;", "()Ljava/lang/String;", "parent_id", "core_debug"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class b {
    static IPatchRedirector $redirector_;

    @NotNull
    private static final ImageView.ScaleType A;
    private static final int B;
    private static final int C;
    private static final int D;
    private static final int E;
    private static final int F;
    private static final int G;
    private static final int H;
    private static final int I;
    private static final int J;
    private static final int K;
    private static final int L;
    private static final int M;
    private static final int N;
    private static final int O;

    @NotNull
    private static final GradientDrawable.Orientation P;

    @NotNull
    private static final GradientDrawable.Orientation Q;

    @NotNull
    private static final GradientDrawable.Orientation R;

    @NotNull
    private static final GradientDrawable.Orientation S;

    @NotNull
    private static final GradientDrawable.Orientation T;

    @NotNull
    private static final GradientDrawable.Orientation U;

    @NotNull
    private static final GradientDrawable.Orientation V;

    @NotNull
    private static final GradientDrawable.Orientation W;
    private static final int X;
    private static final int Y;
    private static final int Z;

    /* renamed from: a, reason: collision with root package name */
    private static final int f69917a;

    /* renamed from: a0, reason: collision with root package name */
    private static final int f69918a0;

    /* renamed from: b, reason: collision with root package name */
    private static final int f69919b;

    /* renamed from: b0, reason: collision with root package name */
    private static final int f69920b0;

    /* renamed from: c, reason: collision with root package name */
    private static final int f69921c;

    /* renamed from: c0, reason: collision with root package name */
    private static final int f69922c0;

    /* renamed from: d, reason: collision with root package name */
    private static final int f69923d = 0;

    /* renamed from: d0, reason: collision with root package name */
    private static final int f69924d0;

    /* renamed from: e, reason: collision with root package name */
    private static final int f69925e;

    /* renamed from: e0, reason: collision with root package name */
    private static final int f69926e0;

    /* renamed from: f, reason: collision with root package name */
    private static final int f69927f;

    /* renamed from: f0, reason: collision with root package name */
    private static final int f69928f0;

    /* renamed from: g, reason: collision with root package name */
    private static final int f69929g;

    /* renamed from: g0, reason: collision with root package name */
    private static final int f69930g0;

    /* renamed from: h, reason: collision with root package name */
    private static final int f69931h;

    /* renamed from: h0, reason: collision with root package name */
    private static final int f69932h0;

    /* renamed from: i, reason: collision with root package name */
    private static final int f69933i;

    /* renamed from: i0, reason: collision with root package name */
    private static final int f69934i0;

    /* renamed from: j, reason: collision with root package name */
    private static final int f69935j;

    /* renamed from: j0, reason: collision with root package name */
    private static final int f69936j0;

    /* renamed from: k, reason: collision with root package name */
    private static final int f69937k;

    /* renamed from: k0, reason: collision with root package name */
    private static final int f69938k0;

    /* renamed from: l, reason: collision with root package name */
    private static final int f69939l;

    /* renamed from: l0, reason: collision with root package name */
    private static final int f69940l0;

    /* renamed from: m, reason: collision with root package name */
    private static final int f69941m;

    /* renamed from: m0, reason: collision with root package name */
    private static final int f69942m0;

    /* renamed from: n, reason: collision with root package name */
    private static final int f69943n;

    /* renamed from: n0, reason: collision with root package name */
    @NotNull
    private static final TextUtils.TruncateAt f69944n0;

    /* renamed from: o, reason: collision with root package name */
    private static final int f69945o;

    /* renamed from: o0, reason: collision with root package name */
    @NotNull
    private static final TextUtils.TruncateAt f69946o0;

    /* renamed from: p, reason: collision with root package name */
    private static final int f69947p;

    /* renamed from: p0, reason: collision with root package name */
    @NotNull
    private static final TextUtils.TruncateAt f69948p0;

    /* renamed from: q, reason: collision with root package name */
    private static final int f69949q;

    /* renamed from: q0, reason: collision with root package name */
    @NotNull
    private static final TextUtils.TruncateAt f69950q0;

    /* renamed from: r, reason: collision with root package name */
    private static final int f69951r;

    /* renamed from: r0, reason: collision with root package name */
    @NotNull
    private static final String f69952r0;

    /* renamed from: s, reason: collision with root package name */
    private static final int f69953s;

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    private static final ImageView.ScaleType f69954t;

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    private static final ImageView.ScaleType f69955u;

    /* renamed from: v, reason: collision with root package name */
    @NotNull
    private static final ImageView.ScaleType f69956v;

    /* renamed from: w, reason: collision with root package name */
    @NotNull
    private static final ImageView.ScaleType f69957w;

    /* renamed from: x, reason: collision with root package name */
    @NotNull
    private static final ImageView.ScaleType f69958x;

    /* renamed from: y, reason: collision with root package name */
    @NotNull
    private static final ImageView.ScaleType f69959y;

    /* renamed from: z, reason: collision with root package name */
    @NotNull
    private static final ImageView.ScaleType f69960z;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7498);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        f69917a = -1;
        f69919b = -2;
        f69921c = -1;
        f69925e = 8;
        f69927f = 4;
        f69929g = 1;
        f69931h = 1;
        f69933i = 2;
        f69935j = 3;
        f69937k = 8388611;
        f69939l = 17;
        f69941m = 3;
        f69943n = 5;
        f69945o = 80;
        f69947p = 48;
        f69949q = 1;
        f69951r = 16;
        f69953s = 8388613;
        f69954t = ImageView.ScaleType.FIT_XY;
        f69955u = ImageView.ScaleType.CENTER_CROP;
        f69956v = ImageView.ScaleType.CENTER;
        f69957w = ImageView.ScaleType.CENTER_INSIDE;
        f69958x = ImageView.ScaleType.FIT_CENTER;
        f69959y = ImageView.ScaleType.FIT_END;
        f69960z = ImageView.ScaleType.MATRIX;
        A = ImageView.ScaleType.FIT_START;
        B = 6;
        C = 7;
        D = 3;
        E = 4;
        F = 5;
        G = 2;
        H = 1;
        I = 2;
        J = 1;
        K = 3;
        L = 5;
        M = 6;
        N = 1;
        O = 2;
        P = GradientDrawable.Orientation.TOP_BOTTOM;
        Q = GradientDrawable.Orientation.TR_BL;
        R = GradientDrawable.Orientation.RIGHT_LEFT;
        S = GradientDrawable.Orientation.BR_TL;
        T = GradientDrawable.Orientation.BOTTOM_TOP;
        U = GradientDrawable.Orientation.BL_TR;
        V = GradientDrawable.Orientation.LEFT_RIGHT;
        W = GradientDrawable.Orientation.TL_BR;
        X = 1;
        Y = 2;
        Z = 3;
        f69918a0 = 1;
        f69920b0 = 2;
        f69922c0 = R.attr.state_enabled;
        f69924d0 = -16842910;
        f69926e0 = R.attr.state_pressed;
        f69928f0 = -16842919;
        f69930g0 = R.attr.state_focused;
        f69932h0 = -16842908;
        f69934i0 = R.attr.state_selected;
        f69936j0 = -16842913;
        f69938k0 = 2;
        f69940l0 = 1;
        f69942m0 = 2;
        f69944n0 = TextUtils.TruncateAt.END;
        f69946o0 = TextUtils.TruncateAt.MARQUEE;
        f69948p0 = TextUtils.TruncateAt.MIDDLE;
        f69950q0 = TextUtils.TruncateAt.START;
        f69952r0 = "0";
    }

    public static final int a() {
        return f69931h;
    }

    @NotNull
    public static final TextUtils.TruncateAt b() {
        return f69944n0;
    }

    public static final int c() {
        return f69921c;
    }

    public static final int d() {
        return f69945o;
    }

    public static final int e() {
        return f69939l;
    }

    public static final int f() {
        return f69949q;
    }

    public static final int g() {
        return f69951r;
    }

    public static final int h() {
        return f69953s;
    }

    public static final int i() {
        return f69941m;
    }

    public static final int j() {
        return f69943n;
    }

    public static final int k() {
        return f69947p;
    }

    public static final int l() {
        return f69917a;
    }

    @NotNull
    public static final String m() {
        return f69952r0;
    }

    public static final int n() {
        return f69929g;
    }

    public static final int o() {
        return f69923d;
    }

    public static final int p() {
        return f69919b;
    }
}
