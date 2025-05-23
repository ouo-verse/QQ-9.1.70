package com.tencent.ecommerce.base.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Property;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsets;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.Scroller;
import androidx.core.view.ViewKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.ecommerce.biz.util.ECDeviceUtils;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import com.tencent.ecommerce.biz.util.r;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 F2\u00020\u00012\u00020\u0002:\u0006\u00b6\u0001\u00b7\u0001\u00b8\u0001B\u001d\u0012\b\u0010\u00b3\u0001\u001a\u00030\u00b2\u0001\u0012\b\u00107\u001a\u0004\u0018\u000106\u00a2\u0006\u0006\b\u00b4\u0001\u0010\u00b5\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0012\u0010\u0011\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0012\u001a\u00020\nH\u0002J\b\u0010\u0013\u001a\u00020\nH\u0002J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0012\u0010\u0016\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0002J\u0012\u0010\u0017\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001b\u001a\u00020\nH\u0002J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0018\u0010\"\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0018H\u0002J(\u0010'\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\bH\u0002J\b\u0010(\u001a\u00020\nH\u0002J\u0018\u0010*\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u001fH\u0002J\u0018\u0010+\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u001fH\u0002J\u0018\u0010,\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u001fH\u0002J\u0018\u0010-\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u001fH\u0002J\u0010\u0010.\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u0005H\u0002J\b\u0010/\u001a\u00020\bH\u0002J\u0018\u00101\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0005H\u0002J\u0010\u00102\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u0005H\u0002J\u001a\u00105\u001a\u00020\n2\u0006\u00103\u001a\u00020\b2\b\u00104\u001a\u0004\u0018\u00010\u000fH\u0002J\u0012\u00108\u001a\u00020\n2\b\u00107\u001a\u0004\u0018\u000106H\u0002J\b\u00109\u001a\u00020\nH\u0002J\b\u0010:\u001a\u00020\nH\u0002J\u0012\u0010;\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010<\u001a\u00020\nH\u0002J\b\u0010=\u001a\u00020\nH\u0002J\b\u0010>\u001a\u00020\nH\u0002J\u0010\u0010@\u001a\u00020\n2\u0006\u0010?\u001a\u00020\bH\u0002J\b\u0010A\u001a\u00020\nH\u0002J\b\u0010B\u001a\u00020\nH\u0002J\b\u0010C\u001a\u00020\nH\u0002J\b\u0010D\u001a\u00020\bH\u0002J\u0018\u0010E\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010F\u001a\u00020\nH\u0002J\u0012\u0010G\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010H\u001a\u00020\nH\u0002J\u0010\u0010I\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010J\u001a\u00020\nH\u0002J\"\u0010M\u001a\u00020\n2\u0006\u0010L\u001a\u00020K2\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005J\"\u0010N\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005J\u000e\u0010Q\u001a\u00020\n2\u0006\u0010P\u001a\u00020OJ\u0010\u0010T\u001a\u00020\n2\b\u0010S\u001a\u0004\u0018\u00010RJ\u0010\u0010U\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010V\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u001a\u0010W\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\u0006\u0010!\u001a\u00020\u0018H\u0016J\b\u0010X\u001a\u00020\nH\u0016J\b\u0010Y\u001a\u00020\nH\u0014J\u0018\u0010[\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010Z\u001a\u00020\u001fJ\u0006\u0010\\\u001a\u00020\nJ\u000e\u0010]\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003R\u0016\u0010_\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010\fR\u0016\u0010a\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010;R\u0016\u0010d\u001a\u00020b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010JR\u0018\u0010P\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u0018\u0010S\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u0018\u0010m\u001a\u0004\u0018\u00010j8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010lR\u0016\u0010o\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bM\u0010nR\u0018\u0010s\u001a\u0004\u0018\u00010p8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bq\u0010rR\u0018\u0010t\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010nR\u0018\u0010u\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010nR\u0018\u0010v\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010nR\u0018\u0010w\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010nR\u0018\u0010x\u001a\u0004\u0018\u00010p8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010rR\u001b\u0010}\u001a\u00020y8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bJ\u0010z\u001a\u0004\b{\u0010|R\u001b\u0010\u007f\u001a\u00020y8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u0010z\u001a\u0004\b~\u0010|R\u001b\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0080\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b1\u0010\u0081\u0001R\u001b\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0083\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b~\u0010\u0084\u0001R)\u0010\u008a\u0001\u001a\r \u0087\u0001*\u0005\u0018\u00010\u0086\u00010\u0086\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0004\b\u0017\u0010z\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R \u0010\u008e\u0001\u001a\u00030\u008b\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u008c\u0001\u0010z\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001R\u0017\u0010\u008f\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010\fR\u0017\u0010\u0090\u0001\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b{\u0010(R\u0018\u0010\u0091\u0001\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0088\u0001\u0010(R\u0017\u0010\u0092\u0001\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010(R\u0017\u0010\u0093\u0001\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010(R\u0017\u0010\u0094\u0001\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010(R\u0017\u0010\u0095\u0001\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010(R\u0017\u0010\u0096\u0001\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010(R\u001e\u0010\u0099\u0001\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0004\b8\u0010z\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001R'\u0010\u009a\u0001\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0004\b\"\u0010;\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001\"\u0006\b\u009c\u0001\u0010\u009d\u0001R\u0017\u0010\u009e\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010;R\u0017\u0010\u009f\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010;R\u0017\u0010\u00a0\u0001\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010(R\u0017\u0010\u00a1\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010\fR\u0017\u0010\u00a2\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010;R\u0017\u0010\u00a3\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010;R\u0017\u0010\u00a4\u0001\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010(R\u0017\u0010\u00a5\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010;R\u0017\u0010\u00a6\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010;R\u0017\u0010\u00a7\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010\fR\u0017\u0010\u00a8\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010;R\u0017\u0010\u00a9\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010\fR\u0017\u0010\u00aa\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010\fR\u0017\u0010\u00ab\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010;R\u0017\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b<\u0010\u00ac\u0001R\u0017\u0010\u00ad\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010\fR\u0018\u0010\u00af\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00ae\u0001\u0010\fR\u0017\u0010\u00b0\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010;R\u0019\u00107\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b5\u0010\u00b1\u0001\u00a8\u0006\u00b9\u0001"}, d2 = {"Lcom/tencent/ecommerce/base/ui/ECFloatGestureLayout;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnTouchListener;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "titleBarViewId", "bottomBarViewId", "", "isDelay", "", "B", "I", "viewId", HippyTKDListViewAdapter.X, "Landroid/view/View;", "titleView", "y", "n0", "G", "v", "view", "w", "N", "Landroid/view/MotionEvent;", "ev", "U", "X", "V", "T", "W", "", "deltaY", "event", "c0", "destX", "destY", "duration", "isFromAutoSuctionTop", "u0", UserInfo.SEX_FEMALE, "velocityY", "d0", "e0", "j0", "k0", "l0", "g0", "type", "L", "K", "isPageAppear", "targetView", "v0", "Landroid/os/Bundle;", "bundle", "b0", "Y", "a0", "Z", "r0", "w0", "o0", "forse", "p0", "s0", "q0", "m0", "f0", "H", "x0", "i0", "u", "h0", "J", "Landroidx/fragment/app/Fragment;", "fragment", BdhLogUtil.LogTag.Tag_Conn, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/ecommerce/base/ui/c;", "floatEventListener", "setFloatEventListener", "Lcom/tencent/ecommerce/base/ui/ECFloatGestureLayout$ContentScrollListener;", "contentScrollListener", "setContentScrollListener", "dispatchTouchEvent", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "onTouch", "computeScroll", NodeProps.ON_DETACHED_FROM_WINDOW, "titleHeight", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "E", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "d", "currentState", "e", "canCloseFromBottom", "", "f", "stateBottomTime", "Lcom/tencent/ecommerce/base/ui/ECFloatGestureLayout$FloatEventListener;", tl.h.F, "Lcom/tencent/ecommerce/base/ui/ECFloatGestureLayout$FloatEventListener;", "i", "Lcom/tencent/ecommerce/base/ui/ECFloatGestureLayout$ContentScrollListener;", "Landroid/view/View$OnLayoutChangeListener;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View$OnLayoutChangeListener;", "layoutChangeListener", "Landroid/view/View;", "containerView", "Landroid/view/ViewGroup;", "D", "Landroid/view/ViewGroup;", "containerOriginParentView", "containerChildView", "maskAnimView", "titleBarView", "bottomView", "titleOriginalParentView", "Landroid/view/animation/TranslateAnimation;", "Lkotlin/Lazy;", BdhLogUtil.LogTag.Tag_Req, "()Landroid/view/animation/TranslateAnimation;", "topToBottomAnim", "M", "bottomToTopAnim", "Landroid/animation/ObjectAnimator;", "Landroid/animation/ObjectAnimator;", "animatorForAlpha", "Landroid/view/animation/AnimationSet;", "Landroid/view/animation/AnimationSet;", "popAnimation", "Landroid/view/VelocityTracker;", "kotlin.jvm.PlatformType", ExifInterface.LATITUDE_SOUTH, "()Landroid/view/VelocityTracker;", "velocityTracker", "Landroid/widget/Scroller;", "P", "()Landroid/widget/Scroller;", "mScroller", "touchStartScrollY", "interceptDeltaY", "mTempDeltaY", "mTempLastY", "mLastX", "mLastY", "mStartRawY", "mStartRawX", "O", "()I", "horizontalTouchSlop", "isAutoSuctionTop", "()Z", "setAutoSuctionTop", "(Z)V", "isDealAutoSuctionTop", "isDisablePulling", "contentScrollMarginTop", "contentMarginTop", "isMaskTrans", "isMarginTopIgnoreBottomBar", NodeProps.BORDER_RADIUS, "isNeedPopAnim", "isNeedResetViewConfig", "containerColor", "isNeedChangeTitleAlpha", "originContainerIndex", "originTitleBarHeight", "isStatusImmersive", "Landroid/app/Activity;", "navigationBarHeight", "t0", "titleBarHashCode", "isNavigationBarExist", "Landroid/os/Bundle;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Landroid/os/Bundle;)V", "c", "ContentScrollListener", "FloatEventListener", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class ECFloatGestureLayout extends FrameLayout implements View.OnTouchListener {

    /* renamed from: C, reason: from kotlin metadata */
    private View containerView;

    /* renamed from: D, reason: from kotlin metadata */
    private ViewGroup containerOriginParentView;

    /* renamed from: E, reason: from kotlin metadata */
    private View containerChildView;

    /* renamed from: F, reason: from kotlin metadata */
    private View maskAnimView;

    /* renamed from: G, reason: from kotlin metadata */
    private View titleBarView;

    /* renamed from: H, reason: from kotlin metadata */
    private View bottomView;

    /* renamed from: I, reason: from kotlin metadata */
    private ViewGroup titleOriginalParentView;

    /* renamed from: J, reason: from kotlin metadata */
    private final Lazy topToBottomAnim;

    /* renamed from: K, reason: from kotlin metadata */
    private final Lazy bottomToTopAnim;

    /* renamed from: L, reason: from kotlin metadata */
    private ObjectAnimator animatorForAlpha;

    /* renamed from: M, reason: from kotlin metadata */
    private AnimationSet popAnimation;

    /* renamed from: N, reason: from kotlin metadata */
    private final Lazy velocityTracker;

    /* renamed from: P, reason: from kotlin metadata */
    private final Lazy mScroller;

    /* renamed from: Q, reason: from kotlin metadata */
    private int touchStartScrollY;

    /* renamed from: R, reason: from kotlin metadata */
    private float interceptDeltaY;

    /* renamed from: S, reason: from kotlin metadata */
    private float mTempDeltaY;

    /* renamed from: T, reason: from kotlin metadata */
    private float mTempLastY;

    /* renamed from: U, reason: from kotlin metadata */
    private float mLastX;

    /* renamed from: V, reason: from kotlin metadata */
    private float mLastY;

    /* renamed from: W, reason: from kotlin metadata */
    private float mStartRawY;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private float mStartRawX;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private final Lazy horizontalTouchSlop;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private boolean isAutoSuctionTop;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int currentState;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private boolean isDealAutoSuctionTop;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean canCloseFromBottom;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private boolean isDisablePulling;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long stateBottomTime;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private float contentScrollMarginTop;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private int contentMarginTop;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private FloatEventListener floatEventListener;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private boolean isMaskTrans;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ContentScrollListener contentScrollListener;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private boolean isMarginTopIgnoreBottomBar;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private float borderRadius;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private boolean isNeedPopAnim;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private boolean isNeedResetViewConfig;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private View.OnLayoutChangeListener layoutChangeListener;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    private int containerColor;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    private boolean isNeedChangeTitleAlpha;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    private int originContainerIndex;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    private int originTitleBarHeight;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    private boolean isStatusImmersive;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    private Activity activity;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    private int navigationBarHeight;

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    private int titleBarHashCode;

    /* renamed from: u0, reason: collision with root package name and from kotlin metadata */
    private boolean isNavigationBarExist;

    /* renamed from: v0, reason: collision with root package name and from kotlin metadata */
    private Bundle bundle;

    /* renamed from: w0, reason: collision with root package name */
    private static final String f101042w0 = "navigationBarBackground";

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/ecommerce/base/ui/ECFloatGestureLayout$ContentScrollListener;", "", "positionState", "", "getPositionState", "()I", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public interface ContentScrollListener {
        int getPositionState();
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0007H&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0007H&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/ecommerce/base/ui/ECFloatGestureLayout$FloatEventListener;", "", "onCustomAnimStart", "", "isFromTop", "", "deltaY", "", "onPageClose", "type", "onPageExposure", "onPopAnimEnd", "onPopAnimStart", "onScrollStateChange", "state", "onStateChange", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public interface FloatEventListener {
        void onCustomAnimStart(boolean isFromTop, int deltaY);

        void onPageClose(boolean isFromTop, int deltaY, int type);

        void onPageExposure();

        void onPopAnimEnd();

        void onPopAnimStart();

        void onScrollStateChange(int state);

        void onStateChange(int state);
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    static final class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECFloatGestureLayout.this.L(0, 2);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\n\u00a2\u0006\u0002\b\u000e"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "onLayoutChange"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    static final class b implements View.OnLayoutChangeListener {
        b() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            View view2 = ECFloatGestureLayout.this.bottomView;
            if (view2 != null && (view2.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                    ECFloatGestureLayout eCFloatGestureLayout = ECFloatGestureLayout.this;
                    eCFloatGestureLayout.navigationBarHeight = eCFloatGestureLayout.Q(ECFloatGestureLayout.e(eCFloatGestureLayout));
                    if (layoutParams2.bottomMargin != ECFloatGestureLayout.this.navigationBarHeight) {
                        layoutParams2.gravity = 80;
                        layoutParams2.bottomMargin = ECFloatGestureLayout.this.navigationBarHeight;
                        view2.setLayoutParams(layoutParams2);
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                }
            }
            ECFloatGestureLayout.this.n0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public static final class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECFloatGestureLayout.this.L(0, 2);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00040\u00042\u000e\u0010\u0005\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n\u00a2\u0006\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"<anonymous>", "Landroid/view/WindowInsets;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "windowInsets", "onApplyWindowInsets", "com/tencent/ecommerce/base/ui/ECFloatGestureLayout$dealContainerScroll$1$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public static final class e implements View.OnApplyWindowInsetsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f101079a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ECFloatGestureLayout f101080b;

        e(int i3, ECFloatGestureLayout eCFloatGestureLayout) {
            this.f101079a = i3;
            this.f101080b = eCFloatGestureLayout;
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            int systemWindowInsetBottom;
            boolean z16;
            if (windowInsets != null) {
                try {
                    systemWindowInsetBottom = windowInsets.getSystemWindowInsetBottom();
                    z16 = systemWindowInsetBottom > 0;
                } catch (Exception e16) {
                    cg0.a.a("ECFloatGestureLayout", "dealContainerScroll", "dealContainerScroll setOnApplyWindowInsetsListener error:" + e16.getMessage());
                }
            } else {
                systemWindowInsetBottom = 0;
                z16 = false;
            }
            cg0.a.b("ECFloatGestureLayout", "check isNavigationBarExist onApplyWindowInsetsListener isShowing:" + z16 + ",isNavigationBarExist:" + this.f101080b.isNavigationBarExist + ",bottom:" + systemWindowInsetBottom + ",height:" + this.f101079a);
            if (z16 && z16 != this.f101080b.isNavigationBarExist) {
                this.f101080b.contentScrollMarginTop -= ECDeviceUtils.f104857e.i(this.f101079a);
                ECFloatGestureLayout.g(this.f101080b).scrollTo(0, -com.tencent.ecommerce.biz.util.e.e(this.f101080b.contentScrollMarginTop));
                ECFloatGestureLayout eCFloatGestureLayout = this.f101080b;
                eCFloatGestureLayout.touchStartScrollY = -com.tencent.ecommerce.biz.util.e.e(eCFloatGestureLayout.contentScrollMarginTop);
                this.f101080b.isNavigationBarExist = z16;
            }
            return windowInsets;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public static final class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECFloatGestureLayout.this.L(0, 2);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/ecommerce/base/ui/ECFloatGestureLayout$j", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "onAnimationStart", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public static final class j extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f101088d;

        j(View view) {
            this.f101088d = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            super.onAnimationEnd(animation);
            View view = this.f101088d;
            if (view != null) {
                view.setLayerType(0, null);
            }
            cg0.a.b("ECFloatGestureLayout", "alpha animation end");
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            super.onAnimationStart(animation);
        }
    }

    public ECFloatGestureLayout(final Context context, Bundle bundle) {
        super(context);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        this.bundle = bundle;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TranslateAnimation>() { // from class: com.tencent.ecommerce.base.ui.ECFloatGestureLayout$topToBottomAnim$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TranslateAnimation invoke() {
                Animation loadAnimation = AnimationUtils.loadAnimation(ECFloatGestureLayout.this.getContext(), R.anim.f1621);
                if (loadAnimation != null) {
                    return (TranslateAnimation) loadAnimation;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.animation.TranslateAnimation");
            }
        });
        this.topToBottomAnim = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<TranslateAnimation>() { // from class: com.tencent.ecommerce.base.ui.ECFloatGestureLayout$bottomToTopAnim$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TranslateAnimation invoke() {
                Animation loadAnimation = AnimationUtils.loadAnimation(ECFloatGestureLayout.this.getContext(), R.anim.f1665);
                if (loadAnimation != null) {
                    return (TranslateAnimation) loadAnimation;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.animation.TranslateAnimation");
            }
        });
        this.bottomToTopAnim = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<VelocityTracker>() { // from class: com.tencent.ecommerce.base.ui.ECFloatGestureLayout$velocityTracker$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final VelocityTracker invoke() {
                return VelocityTracker.obtain();
            }
        });
        this.velocityTracker = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<Scroller>() { // from class: com.tencent.ecommerce.base.ui.ECFloatGestureLayout$mScroller$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Scroller invoke() {
                return new Scroller(context);
            }
        });
        this.mScroller = lazy4;
        this.mStartRawY = -1.0f;
        this.mStartRawX = -1.0f;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.base.ui.ECFloatGestureLayout$horizontalTouchSlop$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return ViewConfiguration.get(ECFloatGestureLayout.this.getContext()).getScaledTouchSlop();
            }
        });
        this.horizontalTouchSlop = lazy5;
        this.isAutoSuctionTop = true;
        this.contentScrollMarginTop = 120.0f;
        this.borderRadius = 8.0f;
        this.isNeedPopAnim = true;
        this.containerColor = ECSkin.INSTANCE.getColor(R.color.f6491p);
        this.titleBarHashCode = -1;
        b0(this.bundle);
        setOnTouchListener(this);
        Y();
        a0();
        setOnClickListener(new a());
        b bVar = new b();
        this.layoutChangeListener = bVar;
        addOnLayoutChangeListener(bVar);
    }

    private final void B(Activity activity, final int titleBarViewId, final int bottomBarViewId, boolean isDelay) {
        this.activity = activity;
        View decorView = activity.getWindow().getDecorView();
        if (decorView != null) {
            View childAt = ((ViewGroup) decorView).getChildAt(0);
            this.containerView = childAt;
            if (childAt instanceof ECFloatGestureLayout) {
                if (childAt == null) {
                    try {
                        Intrinsics.throwUninitializedPropertyAccessException("containerView");
                    } catch (Exception e16) {
                        cg0.a.b("ECFloatGestureLayout", "attachToActivity exception " + e16);
                        return;
                    }
                }
                if (childAt != null) {
                    View childAt2 = ((ViewGroup) childAt).getChildAt(1);
                    if (childAt2 != null) {
                        this.containerChildView = ((ViewGroup) childAt2).getChildAt(0);
                        View view = this.containerView;
                        if (view == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("containerView");
                        }
                        if (view != null) {
                            this.containerView = ((ViewGroup) view).getChildAt(1);
                            b0(this.bundle);
                            u();
                            this.touchStartScrollY = -com.tencent.ecommerce.biz.util.e.e(this.contentScrollMarginTop);
                            childAt.setOnClickListener(new d());
                            this.maskAnimView = ((ECFloatGestureLayout) childAt).maskAnimView;
                            return;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            }
            if (childAt == null) {
                Intrinsics.throwUninitializedPropertyAccessException("containerView");
            }
            if (childAt.getParent() instanceof ViewGroup) {
                View view2 = this.containerView;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("containerView");
                }
                ViewParent parent = view2.getParent();
                if (parent != null) {
                    ViewGroup viewGroup = (ViewGroup) parent;
                    this.containerOriginParentView = viewGroup;
                    View view3 = this.containerView;
                    if (view3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("containerView");
                    }
                    this.originContainerIndex = viewGroup.indexOfChild(view3);
                    FrameLayout frameLayout = new FrameLayout(getContext());
                    ViewGroup viewGroup2 = this.containerOriginParentView;
                    if (viewGroup2 != null) {
                        View view4 = this.containerView;
                        if (view4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("containerView");
                        }
                        viewGroup2.removeView(view4);
                    }
                    View view5 = this.containerView;
                    if (view5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("containerView");
                    }
                    frameLayout.addView(view5);
                    frameLayout.setBackgroundColor(0);
                    View view6 = this.containerView;
                    if (view6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("containerView");
                    }
                    this.containerChildView = view6;
                    this.containerView = frameLayout;
                    addView(frameLayout);
                    cg0.a.b("ECFloatGestureLayout", "has add containerView");
                    ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
                    if (layoutParams != null) {
                        ((FrameLayout.LayoutParams) layoutParams).topMargin = this.contentMarginTop;
                        View view7 = this.containerChildView;
                        if (view7 != null) {
                            view7.setBackgroundColor(this.containerColor);
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
                }
            }
            Z(this.containerChildView);
            if (this.isAutoSuctionTop && this.originTitleBarHeight != 0) {
                View view8 = this.containerView;
                if (view8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("containerView");
                }
                view8.setPadding(0, this.originTitleBarHeight, 0, 0);
            }
            if (this.isNeedPopAnim) {
                if (isDelay) {
                    ECThreadUtilKt.b(150L, new Function0<Unit>() { // from class: com.tencent.ecommerce.base.ui.ECFloatGestureLayout$attachToActivity$3
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            ECFloatGestureLayout.this.I();
                            ECFloatGestureLayout.this.H(titleBarViewId, bottomBarViewId);
                            ECFloatGestureLayout.this.w0();
                        }
                    });
                    return;
                }
                I();
                H(titleBarViewId, bottomBarViewId);
                w0();
                return;
            }
            I();
            H(titleBarViewId, bottomBarViewId);
            FloatEventListener floatEventListener = this.floatEventListener;
            if (floatEventListener != null) {
                floatEventListener.onPageExposure();
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    private final void F() {
        if (this.currentState == 5) {
            this.currentState = 0;
            return;
        }
        View view = this.containerView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
        }
        int scrollY = view.getScrollY();
        float yVelocity = S().getYVelocity(0);
        cg0.a.b("ECFloatGestureLayout", "closeOrSpringBack judge deltaY:" + scrollY + " ,velocityY:" + yVelocity + " ,mCanCloseFromBottom:" + this.canCloseFromBottom + " , mStateBottomTime:" + (System.currentTimeMillis() - this.stateBottomTime) + " , mInterceptDeltaY:" + this.interceptDeltaY);
        if (this.isAutoSuctionTop) {
            if (d0(scrollY, yVelocity)) {
                if (this.isDealAutoSuctionTop) {
                    u0(0, -com.tencent.ecommerce.biz.util.e.e(this.contentScrollMarginTop), 200, false);
                    m0();
                    return;
                } else {
                    L(scrollY, 1);
                    return;
                }
            }
            if (e0(scrollY, yVelocity)) {
                K(scrollY);
                return;
            }
            l0(scrollY);
            this.currentState = 0;
            FloatEventListener floatEventListener = this.floatEventListener;
            if (floatEventListener != null) {
                floatEventListener.onStateChange(0);
                return;
            }
            return;
        }
        if (j0(scrollY, yVelocity)) {
            L(scrollY, 1);
            return;
        }
        if (k0(scrollY, yVelocity)) {
            K(scrollY);
            return;
        }
        u0(0, -com.tencent.ecommerce.biz.util.e.e(this.contentScrollMarginTop), 200, true);
        this.currentState = 0;
        FloatEventListener floatEventListener2 = this.floatEventListener;
        if (floatEventListener2 != null) {
            floatEventListener2.onStateChange(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G() {
        ViewGroup.LayoutParams layoutParams;
        if (this.isNeedChangeTitleAlpha) {
            return;
        }
        View view = this.titleBarView;
        if ((view != null ? view.getParent() : null) instanceof ViewGroup) {
            View view2 = this.titleBarView;
            ViewParent parent = view2 != null ? view2.getParent() : null;
            if (parent != null) {
                ViewGroup viewGroup = (ViewGroup) parent;
                this.titleOriginalParentView = viewGroup;
                viewGroup.removeView(this.titleBarView);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            }
        }
        if (this.isAutoSuctionTop) {
            addView(this.titleBarView);
            cg0.a.b("ECFloatGestureLayout", "has add titleBarView");
            if (this.isStatusImmersive) {
                View view3 = this.titleBarView;
                layoutParams = view3 != null ? view3.getLayoutParams() : null;
                if (layoutParams != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                    int i3 = this.originTitleBarHeight;
                    r rVar = r.f104881b;
                    Activity activity = this.activity;
                    if (activity == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                    }
                    layoutParams2.height = i3 + rVar.a(activity);
                    layoutParams2.topMargin = 0;
                    View view4 = this.titleBarView;
                    if (view4 != null) {
                        Activity activity2 = this.activity;
                        if (activity2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                        }
                        view4.setPadding(0, rVar.a(activity2), 0, 0);
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                }
            } else {
                View view5 = this.titleBarView;
                layoutParams = view5 != null ? view5.getLayoutParams() : null;
                if (layoutParams != null) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) layoutParams;
                    r rVar2 = r.f104881b;
                    Activity activity3 = this.activity;
                    if (activity3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                    }
                    layoutParams3.topMargin = rVar2.a(activity3);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                }
            }
            View view6 = this.titleBarView;
            if (view6 != null) {
                ViewKt.setVisible(view6, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I() {
        View decorView;
        u();
        View view = this.containerView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
        }
        view.scrollTo(0, -com.tencent.ecommerce.biz.util.e.e(this.contentScrollMarginTop));
        this.touchStartScrollY = -com.tencent.ecommerce.biz.util.e.e(this.contentScrollMarginTop);
        if (this.isMarginTopIgnoreBottomBar) {
            return;
        }
        Activity activity = this.activity;
        if (activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        }
        int c16 = com.tencent.ecommerce.base.device.a.f100685b.c(activity, true);
        Window window = activity.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        decorView.setOnApplyWindowInsetsListener(new e(c16, this));
    }

    private final void J() {
        S().recycle();
        View.OnLayoutChangeListener onLayoutChangeListener = this.layoutChangeListener;
        if (onLayoutChangeListener != null) {
            removeOnLayoutChangeListener(onLayoutChangeListener);
        }
    }

    private final void K(int deltaY) {
        M().setAnimationListener(new f(deltaY));
        M().setDuration(200L);
        M().setInterpolator(new AccelerateInterpolator());
        View view = this.containerView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
        }
        view.startAnimation(M());
        v0(false, this.maskAnimView);
    }

    private final TranslateAnimation M() {
        return (TranslateAnimation) this.bottomToTopAnim.getValue();
    }

    private final int O() {
        return ((Number) this.horizontalTouchSlop.getValue()).intValue();
    }

    private final Scroller P() {
        return (Scroller) this.mScroller.getValue();
    }

    private final TranslateAnimation R() {
        return (TranslateAnimation) this.topToBottomAnim.getValue();
    }

    private final VelocityTracker S() {
        return (VelocityTracker) this.velocityTracker.getValue();
    }

    private final boolean T(MotionEvent ev5) {
        if (!this.isAutoSuctionTop || ev5.getAction() == 0 || this.touchStartScrollY > 0) {
            return false;
        }
        if (ev5.getAction() == 2) {
            if (W(ev5)) {
                return true;
            }
            V(ev5);
            return false;
        }
        U(ev5);
        return false;
    }

    private final void U(MotionEvent ev5) {
        float yVelocity = S().getYVelocity(0);
        float rawY = ev5.getRawY();
        if (this.containerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
        }
        if (rawY >= Math.abs(r3.getScrollY()) && Math.abs(ev5.getRawY() - this.mStartRawY) > 5) {
            View view = this.containerView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("containerView");
            }
            if (Math.abs(view.getScrollY()) <= com.tencent.ecommerce.biz.util.e.e(this.contentScrollMarginTop)) {
                x0();
                return;
            }
            float f16 = 0;
            if (yVelocity < f16 && Math.abs(yVelocity) >= QzoneConfig.DEFAULT_PHOTOVIEW_PHOTO_BYTES && this.currentState != 5) {
                x0();
                return;
            }
            if (yVelocity < f16) {
                View view2 = this.containerView;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("containerView");
                }
                if (Math.abs(view2.getScrollY()) > com.tencent.ecommerce.biz.util.e.e(this.contentScrollMarginTop)) {
                    u0(0, -com.tencent.ecommerce.biz.util.e.e(this.contentScrollMarginTop), 200, false);
                }
            }
        }
    }

    private final void V(MotionEvent ev5) {
        float rawY = ev5.getRawY() - this.mStartRawY;
        this.mTempDeltaY = rawY;
        if (rawY < -3) {
            X();
        }
        View view = this.titleBarView;
        if (view != null) {
            ContentScrollListener contentScrollListener = this.contentScrollListener;
            if ((contentScrollListener != null ? contentScrollListener.getPositionState() : 1) == 1) {
                if (!((view.getVisibility() == 0) && view.getAlpha() == 1.0f && this.mTempDeltaY < 0) && Math.abs(this.mTempDeltaY) > 3) {
                    View view2 = this.containerView;
                    if (view2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("containerView");
                    }
                    if (Math.abs(view2.getScrollY()) <= this.originTitleBarHeight) {
                        view.setVisibility(0);
                        float f16 = this.originTitleBarHeight;
                        if (this.containerView == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("containerView");
                        }
                        view.setAlpha((f16 - Math.abs(r2.getScrollY())) / this.originTitleBarHeight);
                        return;
                    }
                    view.setVisibility(8);
                    view.setAlpha(0.0f);
                }
            }
        }
    }

    private final boolean W(MotionEvent ev5) {
        if (!f0()) {
            float rawY = ev5.getRawY();
            if (this.containerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("containerView");
            }
            if (rawY <= Math.abs(r0.getScrollY())) {
                return true;
            }
        }
        return false;
    }

    private final void X() {
        if (this.containerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
        }
        int scrollY = (int) (r0.getScrollY() - this.mTempDeltaY);
        if (scrollY < 0) {
            u0(0, scrollY, 0, true);
        } else {
            u0(0, 0, 0, true);
        }
    }

    private final void Y() {
        View view = new View(getContext());
        this.maskAnimView = view;
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        View view2 = this.maskAnimView;
        if (view2 != null) {
            view2.setBackgroundColor(this.isMaskTrans ? 0 : Color.parseColor("#66000000"));
        }
        View view3 = this.maskAnimView;
        if (view3 != null) {
            view3.setOnClickListener(new h());
        }
        addView(this.maskAnimView);
        cg0.a.b("ECFloatGestureLayout", "has add maskAnimView");
    }

    private final void Z(View view) {
        if (this.borderRadius != 0.0f) {
            if (view != null) {
                view.setOutlineProvider(new com.tencent.ecommerce.richtext.ui.dom.style.e(com.tencent.ecommerce.biz.util.e.e(this.borderRadius), ECDeviceUtils.f104857e.d() - com.tencent.ecommerce.biz.util.e.e(this.contentScrollMarginTop), 1));
            }
            if (view != null) {
                view.setClipToOutline(true);
            }
        }
    }

    private final void a0() {
        if (this.popAnimation == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f1632);
            if (loadAnimation != null) {
                AnimationSet animationSet = (AnimationSet) loadAnimation;
                this.popAnimation = animationSet;
                animationSet.setDuration(200L);
                animationSet.setInterpolator(new AccelerateDecelerateInterpolator());
                animationSet.setAnimationListener(new i());
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.animation.AnimationSet");
        }
    }

    private final boolean c0(float deltaY, MotionEvent event) {
        if (this.contentScrollListener == null || event.getAction() == 0) {
            return false;
        }
        ContentScrollListener contentScrollListener = this.contentScrollListener;
        int positionState = contentScrollListener != null ? contentScrollListener.getPositionState() : 1;
        FloatEventListener floatEventListener = this.floatEventListener;
        if (floatEventListener != null) {
            floatEventListener.onScrollStateChange(positionState);
        }
        if (positionState == 1 && deltaY > 5) {
            this.stateBottomTime = 0L;
        } else {
            if (positionState != 2 || deltaY >= 0 || !this.canCloseFromBottom) {
                this.stateBottomTime = 0L;
                return false;
            }
            if (this.stateBottomTime == 0) {
                this.stateBottomTime = System.currentTimeMillis();
            }
        }
        return true;
    }

    private final boolean d0(int deltaY, float velocityY) {
        if ((deltaY < -500 && velocityY > -100) || (deltaY < -50 && velocityY >= 2800)) {
            return true;
        }
        return false;
    }

    public static final /* synthetic */ Activity e(ECFloatGestureLayout eCFloatGestureLayout) {
        Activity activity = eCFloatGestureLayout.activity;
        if (activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        }
        return activity;
    }

    private final boolean f0() {
        View view = this.containerView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
        }
        return view.getScrollY() >= 0;
    }

    public static final /* synthetic */ View g(ECFloatGestureLayout eCFloatGestureLayout) {
        View view = eCFloatGestureLayout.containerView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
        }
        return view;
    }

    private final boolean g0() {
        int i3 = this.currentState;
        return i3 == 4 || i3 == 3;
    }

    private final boolean h0(MotionEvent ev5) {
        if (ev5.getAction() == 0) {
            return false;
        }
        float rawY = ev5.getRawY();
        float rawX = ev5.getRawX() - this.mStartRawX;
        return Math.abs(rawX) > ((float) O()) && Math.abs(rawY - this.mStartRawY) / Math.abs(rawX) < 0.5f;
    }

    private final boolean j0(int deltaY, float velocityY) {
        if ((deltaY < -500 && velocityY > -100) || (deltaY < -50 && velocityY >= 2800)) {
            return true;
        }
        return false;
    }

    private final void l0(int deltaY) {
        int i3 = this.touchStartScrollY;
        if (i3 < 0 && i3 > (-com.tencent.ecommerce.biz.util.e.e(this.contentScrollMarginTop))) {
            if (this.touchStartScrollY <= (-com.tencent.ecommerce.biz.util.e.e(this.contentScrollMarginTop))) {
                u0(0, -com.tencent.ecommerce.biz.util.e.e(this.contentScrollMarginTop), 200, false);
                m0();
                return;
            }
            return;
        }
        if (this.touchStartScrollY != 0 || deltaY >= (-com.tencent.ecommerce.biz.util.e.e(this.contentScrollMarginTop))) {
            return;
        }
        u0(0, -com.tencent.ecommerce.biz.util.e.e(this.contentScrollMarginTop), 200, false);
        m0();
    }

    private final void m0() {
        Z(this.containerChildView);
        this.isDealAutoSuctionTop = false;
        View view = this.titleBarView;
        if (view != null) {
            ViewKt.setVisible(view, false);
        }
        FloatEventListener floatEventListener = this.floatEventListener;
        if (floatEventListener != null) {
            floatEventListener.onStateChange(7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n0() {
        View view;
        if (!this.isNeedChangeTitleAlpha && this.isAutoSuctionTop && (view = this.titleBarView) != null && this.isStatusImmersive) {
            if ((view != null ? view.getLayoutParams() : null) instanceof FrameLayout.LayoutParams) {
                View view2 = this.titleBarView;
                ViewGroup.LayoutParams layoutParams = view2 != null ? view2.getLayoutParams() : null;
                if (layoutParams != null) {
                    int i3 = ((FrameLayout.LayoutParams) layoutParams).height;
                    int i16 = this.originTitleBarHeight;
                    r rVar = r.f104881b;
                    Activity activity = this.activity;
                    if (activity == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                    }
                    if (i3 != i16 + rVar.a(activity)) {
                        View view3 = this.titleBarView;
                        ViewGroup.LayoutParams layoutParams2 = view3 != null ? view3.getLayoutParams() : null;
                        if (layoutParams2 != null) {
                            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) layoutParams2;
                            int i17 = this.originTitleBarHeight;
                            Activity activity2 = this.activity;
                            if (activity2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                            }
                            layoutParams3.height = i17 + rVar.a(activity2);
                            layoutParams3.topMargin = 0;
                            View view4 = this.titleBarView;
                            if (view4 != null) {
                                Activity activity3 = this.activity;
                                if (activity3 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                                }
                                view4.setPadding(0, rVar.a(activity3), 0, 0);
                                return;
                            }
                            return;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            }
        }
    }

    private final void p0(boolean forse) {
        FloatEventListener floatEventListener;
        q0();
        if (!this.isDealAutoSuctionTop && (floatEventListener = this.floatEventListener) != null) {
            floatEventListener.onStateChange(6);
        }
        this.isDealAutoSuctionTop = true;
        s0();
    }

    private final void q0() {
        if (this.isNeedResetViewConfig) {
            View view = this.containerChildView;
            if (view != null) {
                view.setOutlineProvider(null);
            }
            View view2 = this.containerChildView;
            if (view2 != null) {
                view2.setClipToOutline(false);
            }
        }
    }

    private final void r0() {
        ViewGroup viewGroup = this.containerOriginParentView;
        if (viewGroup != null) {
            viewGroup.addView(this, this.originContainerIndex);
        }
    }

    private final void s0() {
        View view = this.titleBarView;
        if (view != null) {
            view.setVisibility(0);
            view.setAlpha(1.0f);
        }
    }

    private final void u() {
        if (this.isMarginTopIgnoreBottomBar) {
            return;
        }
        float f16 = this.contentScrollMarginTop;
        ECDeviceUtils eCDeviceUtils = ECDeviceUtils.f104857e;
        if (this.activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        }
        this.contentScrollMarginTop = f16 - eCDeviceUtils.i(Q(r2));
    }

    private final void u0(int destX, int destY, int duration, boolean isFromAutoSuctionTop) {
        if (this.currentState == 5) {
            return;
        }
        View view = this.containerView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
        }
        int scrollX = view.getScrollX();
        View view2 = this.containerView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
        }
        int scrollY = view2.getScrollY();
        int i3 = destX - scrollX;
        int i16 = destY - scrollY;
        if (scrollY < 0 && scrollY > -500) {
            this.currentState = 1;
        } else if (scrollY <= -500) {
            this.currentState = 2;
        } else if (scrollY > 0 && scrollY < 300) {
            this.currentState = 3;
        } else if (scrollY >= 300) {
            this.currentState = 4;
        }
        if (g0() && this.interceptDeltaY > 0 && this.contentScrollListener != null && !isFromAutoSuctionTop) {
            this.currentState = 5;
            View view3 = this.containerView;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("containerView");
            }
            view3.scrollTo(0, -com.tencent.ecommerce.biz.util.e.e(this.contentScrollMarginTop));
            m0();
            postInvalidate();
        } else {
            P().startScroll(scrollX, scrollY, i3, i16, duration);
            invalidate();
        }
        FloatEventListener floatEventListener = this.floatEventListener;
        if (floatEventListener != null) {
            floatEventListener.onStateChange(this.currentState);
        }
    }

    private final void v(int viewId) {
        View view = this.containerChildView;
        w(view != null ? view.findViewById(viewId) : null);
    }

    private final void w(final View view) {
        this.bottomView = view;
        if (view == null || !(view.getParent() instanceof ViewGroup)) {
            return;
        }
        view.post(new Runnable() { // from class: com.tencent.ecommerce.base.ui.ECFloatGestureLayout$attachBottomBarByView$$inlined$let$lambda$1
            @Override // java.lang.Runnable
            public final void run() {
                ViewParent parent = view.getParent();
                if (parent != null) {
                    ((ViewGroup) parent).removeView(this.bottomView);
                    ECFloatGestureLayout eCFloatGestureLayout = this;
                    eCFloatGestureLayout.addView(eCFloatGestureLayout.bottomView);
                    cg0.a.b("ECFloatGestureLayout", "has add bottomView");
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    if (layoutParams != null) {
                        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                        layoutParams2.gravity = 80;
                        ECFloatGestureLayout eCFloatGestureLayout2 = this;
                        layoutParams2.bottomMargin = eCFloatGestureLayout2.Q(ECFloatGestureLayout.e(eCFloatGestureLayout2));
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w0() {
        View view;
        View view2 = this.containerView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
        }
        view2.startAnimation(this.popAnimation);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f1632);
        if (loadAnimation != null) {
            AnimationSet animationSet = (AnimationSet) loadAnimation;
            animationSet.setDuration(200L);
            animationSet.setInterpolator(new AccelerateDecelerateInterpolator());
            if (ECDeviceUtils.f104857e.h() || (view = this.bottomView) == null) {
                return;
            }
            view.startAnimation(animationSet);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.animation.AnimationSet");
    }

    private final void x(int viewId) {
        View view = this.containerChildView;
        View findViewById = view != null ? view.findViewById(viewId) : null;
        this.titleBarView = findViewById;
        y(findViewById);
    }

    public final void C(Fragment fragment, int titleBarViewId, int bottomBarViewId) {
        FragmentActivity activity = fragment.getActivity();
        if (activity != null) {
            A(activity, titleBarViewId, bottomBarViewId);
        }
    }

    public final int Q(Activity activity) {
        com.tencent.ecommerce.base.device.a aVar = com.tencent.ecommerce.base.device.a.f100685b;
        Activity activity2 = this.activity;
        if (activity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        }
        int c16 = aVar.c(activity2, true);
        int d16 = ECDeviceUtils.f104857e.d();
        int N = N(activity);
        int i3 = d16 - N;
        this.isNavigationBarExist = i0(activity);
        cg0.a.b("ECFloatGestureLayout", "attachToActivity original contentMarginTop:" + com.tencent.ecommerce.biz.util.e.c(this.contentScrollMarginTop) + ",nav height:" + c16 + ",screenHeight:" + d16 + ",contentHeight:" + N + ",isNavigationBarExist:" + this.isNavigationBarExist);
        if (i3 == 0) {
            c16 = 0;
        }
        if (this.isNavigationBarExist) {
            return c16;
        }
        return 0;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (P().computeScrollOffset()) {
            if (!this.isAutoSuctionTop) {
                if (Math.abs(P().getCurrY()) >= com.tencent.ecommerce.biz.util.e.e(this.contentScrollMarginTop)) {
                    View view = this.containerView;
                    if (view == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("containerView");
                    }
                    view.scrollTo(P().getCurrX(), P().getCurrY());
                }
            } else {
                View view2 = this.containerView;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("containerView");
                }
                if (view2.getScrollY() <= 0 && P().getCurrY() > 0) {
                    View view3 = this.containerView;
                    if (view3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("containerView");
                    }
                    view3.scrollTo(P().getCurrX(), 0);
                    o0();
                } else {
                    if (P().getCurrY() <= 0 && P().getCurrY() >= -18) {
                        q0();
                    }
                    View view4 = this.containerView;
                    if (view4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("containerView");
                    }
                    view4.scrollTo(P().getCurrX(), P().getCurrY());
                }
            }
            postInvalidate();
            return;
        }
        View view5 = this.containerView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
        }
        if (view5.getScrollY() != 0 || this.currentState == 0) {
            return;
        }
        ECThreadUtilKt.b(32L, new Function0<Unit>() { // from class: com.tencent.ecommerce.base.ui.ECFloatGestureLayout$computeScroll$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ECFloatGestureLayout.this.currentState = 0;
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev5) {
        if (ev5.getAction() == 0) {
            View view = this.containerView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("containerView");
            }
            this.touchStartScrollY = view.getScrollY();
            this.mStartRawY = ev5.getRawY();
            this.mStartRawX = ev5.getRawX();
        }
        if (this.isDisablePulling) {
            return super.dispatchTouchEvent(ev5);
        }
        if (h0(ev5)) {
            return super.dispatchTouchEvent(ev5);
        }
        S().addMovement(ev5);
        if (T(ev5)) {
            return super.dispatchTouchEvent(ev5);
        }
        this.mTempLastY = ev5.getRawY();
        return super.dispatchTouchEvent(ev5);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        J();
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev5) {
        if (this.isDisablePulling) {
            return false;
        }
        this.interceptDeltaY = this.mLastY != 0.0f ? ev5.getRawY() - this.mLastY : 0.0f;
        this.mLastX = ev5.getRawX();
        this.mLastY = ev5.getRawY();
        if (h0(ev5)) {
            return false;
        }
        return c0(this.interceptDeltaY, ev5);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v3, MotionEvent event) {
        if (event.getAction() == 0 || this.contentScrollListener == null) {
            return false;
        }
        if (!f0()) {
            float rawY = event.getRawY();
            if (this.containerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("containerView");
            }
            if (rawY <= Math.abs(r2.getScrollY())) {
                View view = this.containerView;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("containerView");
                }
                if (view.getScrollY() >= (-com.tencent.ecommerce.biz.util.e.e(this.contentScrollMarginTop))) {
                    return false;
                }
            }
        }
        S().addMovement(event);
        float rawY2 = this.mLastY != 0.0f ? event.getRawY() - this.mLastY : 0.0f;
        this.mLastX = event.getRawX();
        this.mLastY = event.getRawY();
        int action = event.getAction();
        if (action == 1) {
            S().computeCurrentVelocity(1000);
            S().getYVelocity(0);
            if (this.isAutoSuctionTop) {
                float rawY3 = event.getRawY();
                View view2 = this.containerView;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("containerView");
                }
                int abs = Math.abs(view2.getScrollY());
                if (this.containerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("containerView");
                }
                if (rawY3 >= abs + Math.abs(r2.getPaddingTop())) {
                    F();
                } else {
                    View view3 = this.containerView;
                    if (view3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("containerView");
                    }
                    if (view3.getScrollY() != 0) {
                        L(0, 2);
                    }
                }
            } else {
                F();
            }
        } else if (action != 2) {
            S().computeCurrentVelocity(1000);
            if (this.isAutoSuctionTop) {
                float rawY4 = event.getRawY();
                View view4 = this.containerView;
                if (view4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("containerView");
                }
                int abs2 = Math.abs(view4.getScrollY());
                if (this.containerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("containerView");
                }
                if (rawY4 >= abs2 + Math.abs(r2.getPaddingTop())) {
                    F();
                } else {
                    View view5 = this.containerView;
                    if (view5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("containerView");
                    }
                    if (view5.getScrollY() != 0) {
                        L(0, 2);
                    }
                }
            } else {
                F();
            }
        } else {
            if (this.containerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("containerView");
            }
            u0(0, (int) (r7.getScrollY() - rawY2), 0, false);
        }
        return true;
    }

    public final void setAutoSuctionTop(boolean z16) {
        this.isAutoSuctionTop = z16;
    }

    public final void setContentScrollListener(ContentScrollListener contentScrollListener) {
        this.contentScrollListener = contentScrollListener;
    }

    public final void setFloatEventListener(c floatEventListener) {
        this.floatEventListener = floatEventListener;
    }

    public final void z(final View titleView, final float titleHeight) {
        this.titleBarView = titleView;
        if (titleView == null || !(titleView.getParent() instanceof ViewGroup)) {
            return;
        }
        if (this.titleBarHashCode != (titleView != null ? titleView.hashCode() : 0)) {
            this.titleBarHashCode = titleView != null ? titleView.hashCode() : 0;
            titleView.setVisibility(4);
            if (this.originTitleBarHeight != 0) {
                G();
                return;
            }
            int i3 = (int) titleHeight;
            this.originTitleBarHeight = i3;
            if (i3 == 0) {
                post(new Runnable() { // from class: com.tencent.ecommerce.base.ui.ECFloatGestureLayout$attachTitleBarByView$$inlined$let$lambda$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.originTitleBarHeight = titleView.getHeight();
                        this.G();
                    }
                });
            } else {
                G();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(int titleBarViewId, int bottomBarViewId) {
        v0(true, this.maskAnimView);
        r0();
        if (titleBarViewId != -1) {
            x(titleBarViewId);
        }
        if (bottomBarViewId != -1) {
            v(bottomBarViewId);
        }
    }

    private final void o0() {
        p0(false);
    }

    private final void y(View titleView) {
        z(titleView, 0.0f);
    }

    public final void A(Activity activity, int titleBarViewId, int bottomBarViewId) {
        B(activity, titleBarViewId, bottomBarViewId, true);
    }

    private final int N(Activity activity) {
        Window window;
        if (((activity == null || (window = activity.getWindow()) == null) ? null : window.getDecorView()) == null) {
            return 0;
        }
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect.height();
    }

    private final void b0(Bundle bundle) {
        if (bundle != null) {
            if (bundle.containsKey("scroll_margin_top")) {
                this.contentScrollMarginTop = bundle.getInt("scroll_margin_top", 120);
            }
            if (bundle.containsKey("scroll_to_top")) {
                this.isAutoSuctionTop = bundle.getBoolean("scroll_to_top", true);
            }
            if (bundle.containsKey(LayoutAttrDefine.BorderRadius)) {
                this.borderRadius = bundle.getFloat(LayoutAttrDefine.BorderRadius, 8.0f);
            }
            if (bundle.containsKey("need_pop_anim")) {
                this.isNeedPopAnim = bundle.getBoolean("need_pop_anim", true);
            }
            if (bundle.containsKey("need_change_title_alpha")) {
                this.isNeedChangeTitleAlpha = bundle.getBoolean("need_change_title_alpha", false);
            }
            if (bundle.containsKey("status_immersive")) {
                this.isStatusImmersive = bundle.getBoolean("status_immersive", false);
            }
            if (bundle.containsKey("container_color")) {
                this.containerColor = bundle.getInt("container_color", ECSkin.INSTANCE.getColor(R.color.f6491p));
            }
            if (bundle.containsKey("disallow_pulling")) {
                this.isDisablePulling = bundle.getBoolean("disallow_pulling", false);
            }
            if (bundle.containsKey("need_reset_view_config")) {
                this.isNeedResetViewConfig = bundle.getBoolean("need_reset_view_config", false);
            }
            if (bundle.containsKey(LayoutAttrDefine.MARGIN_TOP)) {
                this.contentMarginTop = bundle.getInt(LayoutAttrDefine.MARGIN_TOP, 0);
            }
            if (bundle.containsKey("mask_view_trans")) {
                this.isMaskTrans = bundle.getBoolean("mask_view_trans", false);
            }
            if (bundle.containsKey("margin_top_ignore_bottom_bar")) {
                this.isMarginTopIgnoreBottomBar = bundle.getBoolean("margin_top_ignore_bottom_bar", false);
            }
        }
    }

    private final boolean i0(Activity activity) {
        Window window;
        View decorView = (activity == null || (window = activity.getWindow()) == null) ? null : window.getDecorView();
        if (decorView != null) {
            ViewGroup viewGroup = (ViewGroup) decorView;
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                viewGroup.getChildAt(i3).getContext().getPackageName();
                if (viewGroup.getChildAt(i3).getId() != -1 && Intrinsics.areEqual(f101042w0, activity.getResources().getResourceEntryName(viewGroup.getChildAt(i3).getId())) && viewGroup.getChildAt(i3).getHeight() != 0) {
                    return true;
                }
            }
            return false;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public final void E() {
        L(0, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L(int deltaY, int type) {
        if (type == 2 && !this.isAutoSuctionTop && this.mStartRawY > com.tencent.ecommerce.biz.util.e.e(this.contentScrollMarginTop)) {
            cg0.a.b("ECFloatGestureLayout", "doCloseAnimTopToBottom return by click inner area");
            return;
        }
        R().setAnimationListener(new g(deltaY, type));
        R().setDuration(200L);
        R().setInterpolator(new AccelerateInterpolator());
        View view = this.containerView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
        }
        view.startAnimation(R());
        View view2 = this.bottomView;
        if (view2 != null) {
            ViewKt.setVisible(view2, false);
        }
        View view3 = this.titleBarView;
        if (view3 != null) {
            ViewKt.setVisible(view3, false);
        }
        v0(false, this.maskAnimView);
    }

    private final void v0(boolean isPageAppear, View targetView) {
        ObjectAnimator ofFloat;
        if (targetView != null) {
            ViewKt.setVisible(targetView, true);
        }
        if (targetView != null) {
            targetView.setLayerType(2, null);
        }
        if (isPageAppear) {
            ofFloat = ObjectAnimator.ofFloat(targetView, (Property<View, Float>) View.ALPHA, 0.0f, 1.0f);
        } else {
            ofFloat = ObjectAnimator.ofFloat(targetView, (Property<View, Float>) View.ALPHA, 1.0f, 0.0f);
        }
        this.animatorForAlpha = ofFloat;
        if (ofFloat != null) {
            ofFloat.addListener(new j(targetView));
        }
        ObjectAnimator objectAnimator = this.animatorForAlpha;
        if (objectAnimator != null) {
            objectAnimator.setDuration(150L);
        }
        ObjectAnimator objectAnimator2 = this.animatorForAlpha;
        if (objectAnimator2 != null) {
            objectAnimator2.setInterpolator(new LinearInterpolator());
        }
        ObjectAnimator objectAnimator3 = this.animatorForAlpha;
        if (objectAnimator3 != null) {
            objectAnimator3.start();
        }
    }

    private final void x0() {
        u0(0, 0, 100, true);
        o0();
    }

    public static /* synthetic */ void D(ECFloatGestureLayout eCFloatGestureLayout, Fragment fragment, int i3, int i16, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            i3 = -1;
        }
        if ((i17 & 4) != 0) {
            i16 = -1;
        }
        eCFloatGestureLayout.C(fragment, i3, i16);
    }

    private final boolean e0(int deltaY, float velocityY) {
        return (deltaY > 300 || velocityY < ((float) (-6500))) && this.canCloseFromBottom && velocityY < ((float) 100) && System.currentTimeMillis() - this.stateBottomTime >= 200 && this.interceptDeltaY < ((float) 0);
    }

    private final boolean k0(int deltaY, float velocityY) {
        return (deltaY > 300 || velocityY < ((float) (-6500))) && this.canCloseFromBottom && velocityY < ((float) 100) && System.currentTimeMillis() - this.stateBottomTime >= 200 && this.interceptDeltaY < ((float) 0);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/ecommerce/base/ui/ECFloatGestureLayout$f", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public static final class f implements Animation.AnimationListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f101082e;

        f(int i3) {
            this.f101082e = i3;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            FloatEventListener floatEventListener = ECFloatGestureLayout.this.floatEventListener;
            if (floatEventListener != null) {
                floatEventListener.onPageClose(false, this.f101082e, 2);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/ecommerce/base/ui/ECFloatGestureLayout$g", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public static final class g implements Animation.AnimationListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f101084e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f101085f;

        g(int i3, int i16) {
            this.f101084e = i3;
            this.f101085f = i16;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            ECFloatGestureLayout.g(ECFloatGestureLayout.this).setVisibility(8);
            View view = ECFloatGestureLayout.this.bottomView;
            if (view != null) {
                ViewKt.setVisible(view, false);
            }
            View view2 = ECFloatGestureLayout.this.titleBarView;
            if (view2 != null) {
                ViewKt.setVisible(view2, false);
            }
            FloatEventListener floatEventListener = ECFloatGestureLayout.this.floatEventListener;
            if (floatEventListener != null) {
                floatEventListener.onPageClose(true, this.f101084e, this.f101085f);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b\u00b8\u0006\u0000"}, d2 = {"com/tencent/ecommerce/base/ui/ECFloatGestureLayout$initPopAnim$1$1", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public static final class i implements Animation.AnimationListener {
        i() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            ECFloatGestureLayout.g(ECFloatGestureLayout.this).setLayerType(0, null);
            FloatEventListener floatEventListener = ECFloatGestureLayout.this.floatEventListener;
            if (floatEventListener != null) {
                floatEventListener.onPopAnimEnd();
            }
            FloatEventListener floatEventListener2 = ECFloatGestureLayout.this.floatEventListener;
            if (floatEventListener2 != null) {
                floatEventListener2.onPageExposure();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            FloatEventListener floatEventListener = ECFloatGestureLayout.this.floatEventListener;
            if (floatEventListener != null) {
                floatEventListener.onPopAnimStart();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }
}
