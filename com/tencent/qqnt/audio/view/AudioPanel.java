package com.tencent.qqnt.audio.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ptt.j;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.audio.view.component.MoveDistIndicateView;
import com.tencent.qqnt.audio.view.component.PttTipSwitchView;
import com.tencent.qqnt.audio.view.component.VolumeChangeView;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\u00b2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 ~2\u00020\u00012\u00020\u0002:\u0005\u007f\u0080\u0001\u0081\u0001B\u0011\b\u0016\u0012\u0006\u0010v\u001a\u00020u\u00a2\u0006\u0004\bw\u0010xB\u001b\b\u0016\u0012\u0006\u0010v\u001a\u00020u\u0012\b\u0010z\u001a\u0004\u0018\u00010y\u00a2\u0006\u0004\bw\u0010{B#\b\u0016\u0012\u0006\u0010v\u001a\u00020u\u0012\b\u0010z\u001a\u0004\u0018\u00010y\u0012\u0006\u0010|\u001a\u00020\u000b\u00a2\u0006\u0004\bw\u0010}J\b\u0010\u0004\u001a\u00020\u0003H\u0003J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0002J0\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0002J\b\u0010\u0015\u001a\u00020\u0003H\u0002J\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u000fH\u0002J\u0018\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000bH\u0002J\b\u0010\u001e\u001a\u00020\u0003H\u0002J\u000e\u0010!\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u001fJ\u0006\u0010\"\u001a\u00020\u0003J\u0006\u0010\u0010\u001a\u00020\u0003J\u0006\u0010#\u001a\u00020\u0003J\u0006\u0010$\u001a\u00020\u0003J\u0016\u0010'\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u0011J&\u0010-\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u00112\u0016\u0010,\u001a\u0012\u0012\u0004\u0012\u00020*0)j\b\u0012\u0004\u0012\u00020*`+J\u0018\u0010.\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00109\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u00108R\u0016\u0010<\u001a\u00020:8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010;R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010;R\u0016\u0010@\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010?R\u0016\u0010B\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010?R\u0016\u0010D\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010?R\u0016\u0010G\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010I\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bH\u0010FR\u0016\u0010K\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bJ\u00108R\u0016\u0010N\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010X\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010MR\u0016\u0010Z\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010MR\u0016\u0010\\\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010MR\u0016\u0010^\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010MR\u0016\u0010`\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010MR\u0016\u0010d\u001a\u00020a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010fR\u0016\u0010j\u001a\u00020g8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010l\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010PR\u0016\u0010n\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010CR\u0016\u0010p\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010CR\u0016\u0010r\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bq\u0010CR\u0016\u0010t\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010C\u00a8\u0006\u0082\u0001"}, d2 = {"Lcom/tencent/qqnt/audio/view/AudioPanel;", "Landroid/widget/RelativeLayout;", "Landroid/view/View$OnTouchListener;", "", "k", "u", "", "activated", HippyTKDListViewAdapter.X, "t", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "level", "i", "leftType", "Landroid/view/View;", "v", "", "centerX", "radis", "g", "j", "view", "Landroid/view/MotionEvent;", "event", h.F, "y", "Lcom/tencent/qqnt/audio/view/component/MoveDistIndicateView;", "animEndLevel", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "B", "Lcom/tencent/qqnt/audio/view/f;", "panelListener", "setListener", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "maxAmplitude", "time", "o", "totalTime", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "audioData", "l", "onTouch", "Lcom/tencent/qqnt/audio/view/component/PttTipSwitchView;", "d", "Lcom/tencent/qqnt/audio/view/component/PttTipSwitchView;", "tipsView", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "speakTimeView", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "volumeStateContainer", "Lcom/tencent/qqnt/audio/view/component/VolumeChangeView;", "Lcom/tencent/qqnt/audio/view/component/VolumeChangeView;", "volumeLeftView", "volumeRightView", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "pressBgView", BdhLogUtil.LogTag.Tag_Conn, "pressFgView", "D", "pressView", "E", "Lcom/tencent/qqnt/audio/view/component/MoveDistIndicateView;", "playView", UserInfo.SEX_FEMALE, "deleteView", "G", "moveDirectContainer", "H", "Z", "touchValid", "Lcom/tencent/qqnt/audio/view/AudioPanel$TouchArea;", "I", "Lcom/tencent/qqnt/audio/view/AudioPanel$TouchArea;", "touchArea", "Lcom/tencent/qqnt/audio/view/AudioPanel$PressState;", "J", "Lcom/tencent/qqnt/audio/view/AudioPanel$PressState;", "pressState", "K", "pressAnimFlagPlay", "L", "pressAnimFlagDelete", "M", "mIsTouchMoveFromListenDelIv", "N", "mNeedShowListenButtonScaleOutAnim", "P", "mNeedShowDelButtonScaleOutAnim", "Lcom/tencent/mobileqq/ptt/j;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/ptt/j;", "pttAudioDataManager", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/qqnt/audio/view/f;", "Landroid/os/Handler;", ExifInterface.LATITUDE_SOUTH, "Landroid/os/Handler;", "uiHandler", "T", "screenMidX", "U", "centerListerIvX", "V", "listerIv", "W", "centerDelIvX", "a0", "delIvX", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b0", "a", "PressState", "TouchArea", "qq_audio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AudioPanel extends RelativeLayout implements View.OnTouchListener {
    static IPatchRedirector $redirector_;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView pressFgView;

    /* renamed from: D, reason: from kotlin metadata */
    private ImageView pressView;

    /* renamed from: E, reason: from kotlin metadata */
    private MoveDistIndicateView playView;

    /* renamed from: F, reason: from kotlin metadata */
    private MoveDistIndicateView deleteView;

    /* renamed from: G, reason: from kotlin metadata */
    private ViewGroup moveDirectContainer;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean touchValid;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private TouchArea touchArea;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private PressState pressState;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean pressAnimFlagPlay;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean pressAnimFlagDelete;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean mIsTouchMoveFromListenDelIv;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean mNeedShowListenButtonScaleOutAnim;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean mNeedShowDelButtonScaleOutAnim;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private j pttAudioDataManager;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private f panelListener;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private Handler uiHandler;

    /* renamed from: T, reason: from kotlin metadata */
    private int screenMidX;

    /* renamed from: U, reason: from kotlin metadata */
    private double centerListerIvX;

    /* renamed from: V, reason: from kotlin metadata */
    private double listerIv;

    /* renamed from: W, reason: from kotlin metadata */
    private double centerDelIvX;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private double delIvX;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private PttTipSwitchView tipsView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView speakTimeView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ViewGroup volumeStateContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private VolumeChangeView volumeLeftView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private VolumeChangeView volumeRightView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView pressBgView;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/audio/view/AudioPanel$PressState;", "", "(Ljava/lang/String;I)V", "Send", "Play", "Delete", "qq_audio_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class PressState {
        private static final /* synthetic */ PressState[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final PressState Delete;
        public static final PressState Play;
        public static final PressState Send;

        private static final /* synthetic */ PressState[] $values() {
            return new PressState[]{Send, Play, Delete};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36533);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            Send = new PressState("Send", 0);
            Play = new PressState("Play", 1);
            Delete = new PressState("Delete", 2);
            $VALUES = $values();
        }

        PressState(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static PressState valueOf(String str) {
            return (PressState) Enum.valueOf(PressState.class, str);
        }

        public static PressState[] values() {
            return (PressState[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/audio/view/AudioPanel$TouchArea;", "", "(Ljava/lang/String;I)V", "None", "Play", "Delete", "Common", "qq_audio_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class TouchArea {
        private static final /* synthetic */ TouchArea[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final TouchArea Common;
        public static final TouchArea Delete;
        public static final TouchArea None;
        public static final TouchArea Play;

        private static final /* synthetic */ TouchArea[] $values() {
            return new TouchArea[]{None, Play, Delete, Common};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36539);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            None = new TouchArea("None", 0);
            Play = new TouchArea("Play", 1);
            Delete = new TouchArea("Delete", 2);
            Common = new TouchArea("Common", 3);
            $VALUES = $values();
        }

        TouchArea(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static TouchArea valueOf(String str) {
            return (TouchArea) Enum.valueOf(TouchArea.class, str);
        }

        public static TouchArea[] values() {
            return (TouchArea[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/audio/view/AudioPanel$a;", "", "", "millis", "", "a", "CLEAR_VIBRATOR_LEVEL", "I", "ENTER_LEVEL", "MAX_LEVEL", "MIN_LEVEL", "MSG_SPEAK", "", "PRESS_BETWEEN_SPEAK_TIME", "J", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq_audio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.audio.view.AudioPanel$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @Nullable
        public final String a(int millis) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this, millis);
            }
            if (millis < 1000) {
                i3 = 0;
            } else {
                i3 = (int) ((millis / 1000) + 0.5d);
            }
            int i16 = i3 / 60;
            int i17 = i3 % 60;
            if (i17 < 10) {
                return i16 + ":0" + i17;
            }
            return i16 + ":" + i17;
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f352627a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f352628b;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36541);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[TouchArea.values().length];
            try {
                iArr[TouchArea.Play.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TouchArea.Delete.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TouchArea.Common.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f352627a = iArr;
            int[] iArr2 = new int[PressState.values().length];
            try {
                iArr2[PressState.Play.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[PressState.Delete.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            f352628b = iArr2;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/audio/view/AudioPanel$c", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "qq_audio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class c implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MoveDistIndicateView f352629d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f352630e;

        c(MoveDistIndicateView moveDistIndicateView, int i3) {
            this.f352629d = moveDistIndicateView;
            this.f352630e = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) moveDistIndicateView, i3);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@NotNull Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            } else {
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.f352629d.setLevel(this.f352630e);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@NotNull Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            } else {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@NotNull Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            } else {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36550);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioPanel(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        View.inflate(getContext(), R.layout.dza, this);
        k();
        this.touchArea = TouchArea.None;
        this.pressState = PressState.Send;
        this.pressAnimFlagPlay = true;
        this.pressAnimFlagDelete = true;
        this.pttAudioDataManager = new j();
        this.uiHandler = new Handler(Looper.getMainLooper());
    }

    private final void A() {
        VolumeChangeView volumeChangeView = this.volumeLeftView;
        ViewGroup viewGroup = null;
        if (volumeChangeView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("volumeLeftView");
            volumeChangeView = null;
        }
        volumeChangeView.b();
        VolumeChangeView volumeChangeView2 = this.volumeRightView;
        if (volumeChangeView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("volumeRightView");
            volumeChangeView2 = null;
        }
        volumeChangeView2.b();
        ViewGroup viewGroup2 = this.moveDirectContainer;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moveDirectContainer");
            viewGroup2 = null;
        }
        viewGroup2.setVisibility(0);
        PttTipSwitchView pttTipSwitchView = this.tipsView;
        if (pttTipSwitchView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tipsView");
            pttTipSwitchView = null;
        }
        pttTipSwitchView.setVisibility(8);
        ViewGroup viewGroup3 = this.volumeStateContainer;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("volumeStateContainer");
            viewGroup3 = null;
        }
        viewGroup3.setVisibility(0);
        ImageView imageView = this.pressView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pressView");
            imageView = null;
        }
        imageView.setVisibility(0);
        VolumeChangeView volumeChangeView3 = this.volumeLeftView;
        if (volumeChangeView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("volumeLeftView");
            volumeChangeView3 = null;
        }
        volumeChangeView3.setVisibility(0);
        VolumeChangeView volumeChangeView4 = this.volumeRightView;
        if (volumeChangeView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("volumeRightView");
            volumeChangeView4 = null;
        }
        volumeChangeView4.setVisibility(0);
        MoveDistIndicateView moveDistIndicateView = this.playView;
        if (moveDistIndicateView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playView");
            moveDistIndicateView = null;
        }
        moveDistIndicateView.setLevel(0);
        MoveDistIndicateView moveDistIndicateView2 = this.deleteView;
        if (moveDistIndicateView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deleteView");
            moveDistIndicateView2 = null;
        }
        moveDistIndicateView2.setLevel(0);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.setDuration(150L);
        animationSet.setInterpolator(new LinearInterpolator());
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.86f, 1.0f, 0.86f, 1.0f, 1, 0.5f, 1, 0.5f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        ViewGroup viewGroup4 = this.moveDirectContainer;
        if (viewGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moveDirectContainer");
        } else {
            viewGroup = viewGroup4;
        }
        viewGroup.startAnimation(animationSet);
    }

    private final void B() {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f154793s2);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), R.anim.f154794s3);
        ImageView imageView = this.pressBgView;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pressBgView");
            imageView = null;
        }
        imageView.startAnimation(loadAnimation);
        ImageView imageView3 = this.pressFgView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pressFgView");
        } else {
            imageView2 = imageView3;
        }
        imageView2.startAnimation(loadAnimation2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001a, code lost:
    
        if (r3 != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int g(int x16, boolean leftType, View v3, double centerX, double radis) {
        boolean z16;
        if (v3.getVisibility() != 0) {
            return 0;
        }
        boolean z17 = true;
        if (centerX == 0.0d) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (radis != 0.0d) {
                z17 = false;
            }
        }
        j();
        if (leftType) {
            if (x16 <= centerX && centerX > 0.0d) {
                return 100;
            }
            if (x16 > this.screenMidX) {
                return 0;
            }
        } else {
            if (x16 >= centerX && centerX > 0.0d) {
                return 100;
            }
            if (x16 < this.screenMidX) {
                return 0;
            }
        }
        if (Math.abs(x16 - centerX) >= radis * 1.5d) {
            return 0;
        }
        return 100;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0023, code lost:
    
        if (r0 != 3) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean h(View view, MotionEvent event) {
        int i3;
        int i16;
        int i17;
        MoveDistIndicateView moveDistIndicateView;
        MoveDistIndicateView moveDistIndicateView2;
        int i18;
        PressState pressState;
        int action = event.getAction();
        int rawX = (int) event.getRawX();
        ImageView imageView = null;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                }
            }
            MoveDistIndicateView moveDistIndicateView3 = this.playView;
            if (moveDistIndicateView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playView");
                moveDistIndicateView3 = null;
            }
            moveDistIndicateView3.setLevel(0);
            MoveDistIndicateView moveDistIndicateView4 = this.deleteView;
            if (moveDistIndicateView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deleteView");
                moveDistIndicateView4 = null;
            }
            moveDistIndicateView4.setLevel(0);
            VolumeChangeView volumeChangeView = this.volumeLeftView;
            if (volumeChangeView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("volumeLeftView");
                volumeChangeView = null;
            }
            volumeChangeView.setVisibility(8);
            VolumeChangeView volumeChangeView2 = this.volumeRightView;
            if (volumeChangeView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("volumeRightView");
                volumeChangeView2 = null;
            }
            volumeChangeView2.setVisibility(8);
            f fVar = this.panelListener;
            if (fVar != null) {
                fVar.j(false);
            }
            int i19 = b.f352627a[this.touchArea.ordinal()];
            if (i19 != 1) {
                if (i19 != 2) {
                    if (i19 != 3) {
                        pressState = PressState.Send;
                    } else {
                        pressState = PressState.Send;
                    }
                } else {
                    pressState = PressState.Delete;
                }
            } else {
                pressState = PressState.Play;
            }
            this.pressState = pressState;
            this.touchArea = TouchArea.None;
            this.mIsTouchMoveFromListenDelIv = false;
            this.mNeedShowDelButtonScaleOutAnim = false;
            this.mNeedShowListenButtonScaleOutAnim = false;
            return true;
        }
        this.touchArea = TouchArea.Common;
        MoveDistIndicateView moveDistIndicateView5 = this.playView;
        if (moveDistIndicateView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playView");
            moveDistIndicateView5 = null;
        }
        if (moveDistIndicateView5.getVisibility() == 0) {
            MoveDistIndicateView moveDistIndicateView6 = this.playView;
            if (moveDistIndicateView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playView");
                moveDistIndicateView2 = null;
            } else {
                moveDistIndicateView2 = moveDistIndicateView6;
            }
            i3 = 100;
            i17 = 80;
            int g16 = g(rawX, true, moveDistIndicateView2, this.centerListerIvX, this.listerIv);
            if (g16 > 100) {
                i18 = 100;
            } else {
                i18 = g16;
            }
            if (g16 > 80) {
                this.touchArea = TouchArea.Play;
                MoveDistIndicateView moveDistIndicateView7 = this.playView;
                if (moveDistIndicateView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("playView");
                    moveDistIndicateView7 = null;
                }
                moveDistIndicateView7.setLevel(i18);
                if (this.pressAnimFlagPlay) {
                    this.pressAnimFlagPlay = false;
                    MoveDistIndicateView moveDistIndicateView8 = this.playView;
                    if (moveDistIndicateView8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("playView");
                        moveDistIndicateView8 = null;
                    }
                    y(moveDistIndicateView8);
                    this.mNeedShowListenButtonScaleOutAnim = true;
                }
                i16 = 42;
            } else {
                VolumeChangeView volumeChangeView3 = this.volumeLeftView;
                if (volumeChangeView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("volumeLeftView");
                    volumeChangeView3 = null;
                }
                volumeChangeView3.setVisibility(0);
                VolumeChangeView volumeChangeView4 = this.volumeRightView;
                if (volumeChangeView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("volumeRightView");
                    volumeChangeView4 = null;
                }
                volumeChangeView4.setVisibility(0);
                i16 = 42;
                if (g16 < 42 && !this.pressAnimFlagPlay) {
                    this.pressAnimFlagPlay = true;
                }
                if (this.mNeedShowListenButtonScaleOutAnim) {
                    this.mNeedShowListenButtonScaleOutAnim = false;
                    MoveDistIndicateView moveDistIndicateView9 = this.playView;
                    if (moveDistIndicateView9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("playView");
                        moveDistIndicateView9 = null;
                    }
                    z(moveDistIndicateView9, i18);
                } else {
                    MoveDistIndicateView moveDistIndicateView10 = this.playView;
                    if (moveDistIndicateView10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("playView");
                        moveDistIndicateView10 = null;
                    }
                    moveDistIndicateView10.setLevel(i18);
                }
            }
        } else {
            i3 = 100;
            i16 = 42;
            i17 = 80;
        }
        MoveDistIndicateView moveDistIndicateView11 = this.deleteView;
        if (moveDistIndicateView11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deleteView");
            moveDistIndicateView11 = null;
        }
        if (moveDistIndicateView11.getVisibility() == 0) {
            MoveDistIndicateView moveDistIndicateView12 = this.deleteView;
            if (moveDistIndicateView12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deleteView");
                moveDistIndicateView = null;
            } else {
                moveDistIndicateView = moveDistIndicateView12;
            }
            int i26 = i16;
            int g17 = g(rawX, false, moveDistIndicateView, this.centerDelIvX, this.delIvX);
            if (g17 <= i3) {
                i3 = g17;
            }
            if (g17 > i17) {
                this.touchArea = TouchArea.Delete;
                MoveDistIndicateView moveDistIndicateView13 = this.deleteView;
                if (moveDistIndicateView13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("deleteView");
                    moveDistIndicateView13 = null;
                }
                moveDistIndicateView13.setLevel(i3);
                if (this.pressAnimFlagDelete) {
                    this.pressAnimFlagDelete = false;
                    MoveDistIndicateView moveDistIndicateView14 = this.deleteView;
                    if (moveDistIndicateView14 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("deleteView");
                        moveDistIndicateView14 = null;
                    }
                    y(moveDistIndicateView14);
                    this.mNeedShowDelButtonScaleOutAnim = true;
                }
            } else {
                VolumeChangeView volumeChangeView5 = this.volumeLeftView;
                if (volumeChangeView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("volumeLeftView");
                    volumeChangeView5 = null;
                }
                volumeChangeView5.setVisibility(0);
                VolumeChangeView volumeChangeView6 = this.volumeRightView;
                if (volumeChangeView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("volumeRightView");
                    volumeChangeView6 = null;
                }
                volumeChangeView6.setVisibility(0);
                if (g17 < i26 && !this.pressAnimFlagDelete) {
                    this.pressAnimFlagDelete = true;
                }
                if (this.mNeedShowDelButtonScaleOutAnim) {
                    this.mNeedShowDelButtonScaleOutAnim = false;
                    MoveDistIndicateView moveDistIndicateView15 = this.deleteView;
                    if (moveDistIndicateView15 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("deleteView");
                        moveDistIndicateView15 = null;
                    }
                    z(moveDistIndicateView15, i3);
                } else {
                    MoveDistIndicateView moveDistIndicateView16 = this.deleteView;
                    if (moveDistIndicateView16 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("deleteView");
                        moveDistIndicateView16 = null;
                    }
                    moveDistIndicateView16.setLevel(i3);
                }
            }
        }
        if (view.getId() == R.id.press_to_speak_iv) {
            MoveDistIndicateView moveDistIndicateView17 = this.playView;
            if (moveDistIndicateView17 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playView");
                moveDistIndicateView17 = null;
            }
            if (!moveDistIndicateView17.isPressed()) {
                MoveDistIndicateView moveDistIndicateView18 = this.deleteView;
                if (moveDistIndicateView18 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("deleteView");
                    moveDistIndicateView18 = null;
                }
                if (!moveDistIndicateView18.isPressed()) {
                    MoveDistIndicateView moveDistIndicateView19 = this.playView;
                    if (moveDistIndicateView19 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("playView");
                        moveDistIndicateView19 = null;
                    }
                    moveDistIndicateView19.clearAnimation();
                    MoveDistIndicateView moveDistIndicateView20 = this.deleteView;
                    if (moveDistIndicateView20 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("deleteView");
                    } else {
                        imageView = moveDistIndicateView20;
                    }
                    imageView.clearAnimation();
                    x(false);
                    if (this.mIsTouchMoveFromListenDelIv) {
                        this.mIsTouchMoveFromListenDelIv = false;
                        B();
                    }
                }
            }
            ImageView imageView2 = this.pressBgView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pressBgView");
                imageView2 = null;
            }
            imageView2.clearAnimation();
            ImageView imageView3 = this.pressFgView;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pressFgView");
            } else {
                imageView = imageView3;
            }
            imageView.clearAnimation();
            x(true);
            this.mIsTouchMoveFromListenDelIv = true;
            return true;
        }
        return true;
    }

    private final void i(int level) {
        int a16 = this.pttAudioDataManager.a(level);
        if (QLog.isColorLevel()) {
            QLog.d("AudioPanel", 2, "indicateVolume, " + level + ", " + a16);
        }
        VolumeChangeView volumeChangeView = this.volumeLeftView;
        VolumeChangeView volumeChangeView2 = null;
        if (volumeChangeView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("volumeLeftView");
            volumeChangeView = null;
        }
        volumeChangeView.c(a16);
        VolumeChangeView volumeChangeView3 = this.volumeRightView;
        if (volumeChangeView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("volumeRightView");
        } else {
            volumeChangeView2 = volumeChangeView3;
        }
        volumeChangeView2.c(a16);
    }

    private final void j() {
        this.screenMidX = getResources().getDisplayMetrics().widthPixels / 2;
        MoveDistIndicateView moveDistIndicateView = this.playView;
        MoveDistIndicateView moveDistIndicateView2 = null;
        if (moveDistIndicateView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playView");
            moveDistIndicateView = null;
        }
        double width = moveDistIndicateView.getWidth();
        int[] iArr = new int[2];
        MoveDistIndicateView moveDistIndicateView3 = this.playView;
        if (moveDistIndicateView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playView");
            moveDistIndicateView3 = null;
        }
        moveDistIndicateView3.getLocationOnScreen(iArr);
        double d16 = 2;
        this.centerListerIvX = (width / d16) + iArr[0];
        this.listerIv = width / 2.0d;
        MoveDistIndicateView moveDistIndicateView4 = this.deleteView;
        if (moveDistIndicateView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deleteView");
            moveDistIndicateView4 = null;
        }
        double width2 = moveDistIndicateView4.getWidth();
        int[] iArr2 = new int[2];
        MoveDistIndicateView moveDistIndicateView5 = this.deleteView;
        if (moveDistIndicateView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deleteView");
        } else {
            moveDistIndicateView2 = moveDistIndicateView5;
        }
        moveDistIndicateView2.getLocationOnScreen(iArr2);
        this.centerDelIvX = (width2 / d16) + iArr2[0];
        this.delIvX = width2 / 2.0d;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void k() {
        View findViewById = findViewById(R.id.djl);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.indicate_volume_container)");
        this.volumeStateContainer = (ViewGroup) findViewById;
        View findViewById2 = findViewById(R.id.djn);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.indicate_volume_left_iv)");
        this.volumeLeftView = (VolumeChangeView) findViewById2;
        View findViewById3 = findViewById(R.id.djo);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.indicate_volume_right_iv)");
        this.volumeRightView = (VolumeChangeView) findViewById3;
        View findViewById4 = findViewById(R.id.izm);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.speak_time_tv)");
        this.speakTimeView = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.g3e);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.ptt_tip_switch_view)");
        this.tipsView = (PttTipSwitchView) findViewById5;
        View findViewById6 = findViewById(R.id.f27010f3);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.press_to_speak_background_iv)");
        this.pressBgView = (ImageView) findViewById6;
        View findViewById7 = findViewById(R.id.f27020f4);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.press_to_speak_foreground_iv)");
        this.pressFgView = (ImageView) findViewById7;
        View findViewById8 = findViewById(R.id.press_to_speak_iv);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.press_to_speak_iv)");
        ImageView imageView = (ImageView) findViewById8;
        this.pressView = imageView;
        PttTipSwitchView pttTipSwitchView = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pressView");
            imageView = null;
        }
        imageView.setOnTouchListener(this);
        View findViewById9 = findViewById(R.id.djk);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.indica\u2026e_direction_iv_container)");
        this.moveDirectContainer = (ViewGroup) findViewById9;
        View findViewById10 = findViewById(R.id.bxo);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.enter_listen_panel_iv)");
        MoveDistIndicateView moveDistIndicateView = (MoveDistIndicateView) findViewById10;
        this.playView = moveDistIndicateView;
        if (moveDistIndicateView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playView");
            moveDistIndicateView = null;
        }
        moveDistIndicateView.setType(1);
        MoveDistIndicateView moveDistIndicateView2 = this.playView;
        if (moveDistIndicateView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playView");
            moveDistIndicateView2 = null;
        }
        moveDistIndicateView2.setDisableCustomDraw(true);
        MoveDistIndicateView moveDistIndicateView3 = this.playView;
        if (moveDistIndicateView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playView");
            moveDistIndicateView3 = null;
        }
        moveDistIndicateView3.setImageResource(R.drawable.jar);
        View findViewById11 = findViewById(R.id.izl);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(R.id.speak_panel_del_iv)");
        MoveDistIndicateView moveDistIndicateView4 = (MoveDistIndicateView) findViewById11;
        this.deleteView = moveDistIndicateView4;
        if (moveDistIndicateView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deleteView");
            moveDistIndicateView4 = null;
        }
        moveDistIndicateView4.setType(0);
        MoveDistIndicateView moveDistIndicateView5 = this.deleteView;
        if (moveDistIndicateView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deleteView");
            moveDistIndicateView5 = null;
        }
        moveDistIndicateView5.setDisableCustomDraw(true);
        MoveDistIndicateView moveDistIndicateView6 = this.deleteView;
        if (moveDistIndicateView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deleteView");
            moveDistIndicateView6 = null;
        }
        moveDistIndicateView6.setImageResource(R.drawable.jaq);
        View inflate = View.inflate(getContext(), R.layout.dzb, null);
        PttTipSwitchView pttTipSwitchView2 = this.tipsView;
        if (pttTipSwitchView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tipsView");
        } else {
            pttTipSwitchView = pttTipSwitchView2;
        }
        pttTipSwitchView.addView(inflate);
        v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(AudioPanel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(AudioPanel this$0, int i3, double d16) {
        int parseColor;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.pttAudioDataManager.b()) {
            QLog.d("FUCK", 1, "onRecorderSliceEnd: " + i3);
            this$0.i(i3);
        }
        int i16 = b.f352627a[this$0.touchArea.ordinal()];
        TextView textView = null;
        if (i16 != 1) {
            if (i16 != 2) {
                TextView textView2 = this$0.speakTimeView;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("speakTimeView");
                } else {
                    textView = textView2;
                }
                textView.setText(INSTANCE.a((int) d16));
                this$0.u();
                return;
            }
            TextView textView3 = this$0.speakTimeView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("speakTimeView");
                textView3 = null;
            }
            textView3.setText("\u677e\u624b\u53d6\u6d88\u53d1\u9001");
            parseColor = Color.parseColor("#FF5E6D");
        } else {
            TextView textView4 = this$0.speakTimeView;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("speakTimeView");
                textView4 = null;
            }
            textView4.setText("\u677e\u624b\u8bd5\u542c");
            parseColor = Color.parseColor("#0099FF");
        }
        int parseColor2 = Color.parseColor("#ECECEC");
        VolumeChangeView volumeChangeView = this$0.volumeLeftView;
        if (volumeChangeView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("volumeLeftView");
            volumeChangeView = null;
        }
        volumeChangeView.setColor(parseColor);
        VolumeChangeView volumeChangeView2 = this$0.volumeLeftView;
        if (volumeChangeView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("volumeLeftView");
            volumeChangeView2 = null;
        }
        volumeChangeView2.setBgColor(parseColor2);
        VolumeChangeView volumeChangeView3 = this$0.volumeRightView;
        if (volumeChangeView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("volumeRightView");
            volumeChangeView3 = null;
        }
        volumeChangeView3.setColor(parseColor);
        VolumeChangeView volumeChangeView4 = this$0.volumeRightView;
        if (volumeChangeView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("volumeRightView");
            volumeChangeView4 = null;
        }
        volumeChangeView4.setBgColor(parseColor2);
        TextView textView5 = this$0.speakTimeView;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("speakTimeView");
        } else {
            textView = textView5;
        }
        textView.setTextColor(parseColor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(AudioPanel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(AudioPanel this$0, View v3, MotionEvent event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(v3, "$v");
        Intrinsics.checkNotNullParameter(event, "$event");
        this$0.touchValid = true;
        this$0.h(v3, event);
        this$0.pressState = PressState.Send;
        this$0.B();
        f fVar = this$0.panelListener;
        if (fVar != null) {
            fVar.startRecord();
        }
    }

    private final void t() {
        ViewGroup viewGroup = this.moveDirectContainer;
        VolumeChangeView volumeChangeView = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moveDirectContainer");
            viewGroup = null;
        }
        viewGroup.setVisibility(8);
        PttTipSwitchView pttTipSwitchView = this.tipsView;
        if (pttTipSwitchView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tipsView");
            pttTipSwitchView = null;
        }
        pttTipSwitchView.setVisibility(8);
        ViewGroup viewGroup2 = this.volumeStateContainer;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("volumeStateContainer");
            viewGroup2 = null;
        }
        viewGroup2.setVisibility(8);
        ImageView imageView = this.pressView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pressView");
            imageView = null;
        }
        imageView.setVisibility(0);
        VolumeChangeView volumeChangeView2 = this.volumeLeftView;
        if (volumeChangeView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("volumeLeftView");
            volumeChangeView2 = null;
        }
        volumeChangeView2.setVisibility(8);
        VolumeChangeView volumeChangeView3 = this.volumeRightView;
        if (volumeChangeView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("volumeRightView");
        } else {
            volumeChangeView = volumeChangeView3;
        }
        volumeChangeView.setVisibility(8);
    }

    private final void u() {
        VolumeChangeView volumeChangeView = this.volumeLeftView;
        TextView textView = null;
        if (volumeChangeView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("volumeLeftView");
            volumeChangeView = null;
        }
        volumeChangeView.setColor(Color.parseColor("#424448"));
        VolumeChangeView volumeChangeView2 = this.volumeLeftView;
        if (volumeChangeView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("volumeLeftView");
            volumeChangeView2 = null;
        }
        volumeChangeView2.setBgColor(Color.parseColor("#ECECEC"));
        VolumeChangeView volumeChangeView3 = this.volumeRightView;
        if (volumeChangeView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("volumeRightView");
            volumeChangeView3 = null;
        }
        volumeChangeView3.setColor(Color.parseColor("#424448"));
        VolumeChangeView volumeChangeView4 = this.volumeRightView;
        if (volumeChangeView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("volumeRightView");
            volumeChangeView4 = null;
        }
        volumeChangeView4.setBgColor(Color.parseColor("#ECECEC"));
        ImageView imageView = this.pressBgView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pressBgView");
            imageView = null;
        }
        imageView.setImageResource(R.drawable.jat);
        ImageView imageView2 = this.pressFgView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pressFgView");
            imageView2 = null;
        }
        imageView2.setImageResource(R.drawable.jau);
        ImageView imageView3 = this.pressView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pressView");
            imageView3 = null;
        }
        imageView3.setImageResource(R.drawable.jas);
        TextView textView2 = this.speakTimeView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("speakTimeView");
        } else {
            textView = textView2;
        }
        textView.setTextColor(Color.parseColor("#999999"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(AudioPanel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewGroup viewGroup = this$0.moveDirectContainer;
        VolumeChangeView volumeChangeView = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moveDirectContainer");
            viewGroup = null;
        }
        viewGroup.setVisibility(8);
        ViewGroup viewGroup2 = this$0.volumeStateContainer;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("volumeStateContainer");
            viewGroup2 = null;
        }
        viewGroup2.setVisibility(8);
        PttTipSwitchView pttTipSwitchView = this$0.tipsView;
        if (pttTipSwitchView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tipsView");
            pttTipSwitchView = null;
        }
        pttTipSwitchView.setVisibility(0);
        MoveDistIndicateView moveDistIndicateView = this$0.playView;
        if (moveDistIndicateView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playView");
            moveDistIndicateView = null;
        }
        moveDistIndicateView.clearAnimation();
        MoveDistIndicateView moveDistIndicateView2 = this$0.deleteView;
        if (moveDistIndicateView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deleteView");
            moveDistIndicateView2 = null;
        }
        moveDistIndicateView2.clearAnimation();
        ImageView imageView = this$0.pressBgView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pressBgView");
            imageView = null;
        }
        imageView.clearAnimation();
        ImageView imageView2 = this$0.pressFgView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pressFgView");
            imageView2 = null;
        }
        imageView2.clearAnimation();
        this$0.mIsTouchMoveFromListenDelIv = false;
        this$0.mNeedShowDelButtonScaleOutAnim = false;
        this$0.mNeedShowListenButtonScaleOutAnim = false;
        this$0.x(false);
        ImageView imageView3 = this$0.pressView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pressView");
            imageView3 = null;
        }
        imageView3.setVisibility(0);
        TextView textView = this$0.speakTimeView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("speakTimeView");
            textView = null;
        }
        textView.setText(INSTANCE.a(0));
        VolumeChangeView volumeChangeView2 = this$0.volumeLeftView;
        if (volumeChangeView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("volumeLeftView");
            volumeChangeView2 = null;
        }
        volumeChangeView2.setVisibility(8);
        VolumeChangeView volumeChangeView3 = this$0.volumeRightView;
        if (volumeChangeView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("volumeRightView");
        } else {
            volumeChangeView = volumeChangeView3;
        }
        volumeChangeView.setVisibility(8);
        this$0.u();
    }

    private final void x(boolean activated) {
        ImageView imageView = this.pressView;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pressView");
            imageView = null;
        }
        imageView.setActivated(activated);
        ImageView imageView3 = this.pressBgView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pressBgView");
            imageView3 = null;
        }
        imageView3.setActivated(activated);
        ImageView imageView4 = this.pressFgView;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pressFgView");
        } else {
            imageView2 = imageView4;
        }
        imageView2.setActivated(activated);
    }

    private final void y(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.f154721qn));
    }

    private final void z(MoveDistIndicateView view, int animEndLevel) {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f154722qo);
        loadAnimation.setAnimationListener(new c(view, animEndLevel));
        view.startAnimation(loadAnimation);
    }

    public final void f() {
        f fVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else if (!com.tencent.qqnt.util.permission.a.a(getContext(), QQPermissionConstants.Permission.RECORD_AUDIO) && (fVar = this.panelListener) != null) {
            fVar.z();
        }
    }

    public final void l(double totalTime, @NotNull ArrayList<Byte> audioData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Double.valueOf(totalTime), audioData);
            return;
        }
        Intrinsics.checkNotNullParameter(audioData, "audioData");
        if (totalTime < 500.0d) {
            v();
            return;
        }
        v();
        f fVar = this.panelListener;
        if (fVar != null) {
            int i3 = b.f352628b[this.pressState.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    fVar.y(fVar.getAudioPath(), (float) totalTime, audioData);
                    return;
                }
                String audioPath = fVar.getAudioPath();
                Intrinsics.checkNotNull(audioPath);
                new File(audioPath).delete();
                return;
            }
            fVar.n0(fVar.getAudioPath());
        }
    }

    public final void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            post(new Runnable() { // from class: com.tencent.qqnt.audio.view.d
                @Override // java.lang.Runnable
                public final void run() {
                    AudioPanel.n(AudioPanel.this);
                }
            });
        }
    }

    public final void o(final int maxAmplitude, final double time) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(maxAmplitude), Double.valueOf(time));
        } else {
            post(new Runnable() { // from class: com.tencent.qqnt.audio.view.c
                @Override // java.lang.Runnable
                public final void run() {
                    AudioPanel.p(AudioPanel.this, maxAmplitude, time);
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003b, code lost:
    
        if (r0 != 3) goto L40;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(@NotNull final View v3, @NotNull final MotionEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) v3, (Object) event)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction();
        if (v3.getId() != R.id.press_to_speak_iv) {
            return false;
        }
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (this.touchValid) {
                        h(v3, event);
                    }
                }
            }
            MoveDistIndicateView moveDistIndicateView = this.playView;
            ImageView imageView = null;
            if (moveDistIndicateView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playView");
                moveDistIndicateView = null;
            }
            moveDistIndicateView.clearAnimation();
            MoveDistIndicateView moveDistIndicateView2 = this.deleteView;
            if (moveDistIndicateView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deleteView");
                moveDistIndicateView2 = null;
            }
            moveDistIndicateView2.clearAnimation();
            ImageView imageView2 = this.pressBgView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pressBgView");
                imageView2 = null;
            }
            imageView2.clearAnimation();
            ImageView imageView3 = this.pressFgView;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pressFgView");
            } else {
                imageView = imageView3;
            }
            imageView.clearAnimation();
            x(false);
            if (this.touchValid) {
                this.touchValid = false;
                h(v3, event);
            } else {
                this.uiHandler.removeMessages(1);
            }
        } else {
            x(false);
            j();
            Message obtain = Message.obtain(this.uiHandler, new Runnable() { // from class: com.tencent.qqnt.audio.view.a
                @Override // java.lang.Runnable
                public final void run() {
                    AudioPanel.s(AudioPanel.this, v3, event);
                }
            });
            obtain.what = 1;
            this.uiHandler.sendMessageDelayed(obtain, 150L);
        }
        return true;
    }

    public final void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            post(new Runnable() { // from class: com.tencent.qqnt.audio.view.e
                @Override // java.lang.Runnable
                public final void run() {
                    AudioPanel.r(AudioPanel.this);
                }
            });
        }
    }

    public final void setListener(@NotNull f panelListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) panelListener);
        } else {
            Intrinsics.checkNotNullParameter(panelListener, "panelListener");
            this.panelListener = panelListener;
        }
    }

    public final void v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            post(new Runnable() { // from class: com.tencent.qqnt.audio.view.b
                @Override // java.lang.Runnable
                public final void run() {
                    AudioPanel.w(AudioPanel.this);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioPanel(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        View.inflate(getContext(), R.layout.dza, this);
        k();
        this.touchArea = TouchArea.None;
        this.pressState = PressState.Send;
        this.pressAnimFlagPlay = true;
        this.pressAnimFlagDelete = true;
        this.pttAudioDataManager = new j();
        this.uiHandler = new Handler(Looper.getMainLooper());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioPanel(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        View.inflate(getContext(), R.layout.dza, this);
        k();
        this.touchArea = TouchArea.None;
        this.pressState = PressState.Send;
        this.pressAnimFlagPlay = true;
        this.pressAnimFlagDelete = true;
        this.pttAudioDataManager = new j();
        this.uiHandler = new Handler(Looper.getMainLooper());
    }
}
