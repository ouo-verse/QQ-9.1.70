package com.tencent.timi.game.liveroom.impl.room.floating;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorTRTCRoom;
import com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorMediaControl;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoom;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.widget.chat.ChatFloatingMessageLayout;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.qqlive.common.screen.ScreenUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.liveroom.impl.ipc.TGLiveClientQIPCModule;
import com.tencent.timi.game.liveroom.impl.room.notice.TimiMessagePushDialog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nr2.ab;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uh4.c;
import uh4.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 _2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001`B'\b\u0007\u0012\u0006\u0010Y\u001a\u00020\u0017\u0012\n\b\u0002\u0010[\u001a\u0004\u0018\u00010Z\u0012\b\b\u0002\u0010\\\u001a\u00020\u0007\u00a2\u0006\u0004\b]\u0010^J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\tH\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0002J\b\u0010\u0010\u001a\u00020\u0005H\u0002J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\tH\u0002J\b\u0010\u0013\u001a\u00020\u0005H\u0002J\b\u0010\u0014\u001a\u00020\u0005H\u0002J\b\u0010\u0015\u001a\u00020\u0005H\u0002J\b\u0010\u0016\u001a\u00020\u0005H\u0002J\"\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u0010\u001d\u001a\u00020\u0005H\u0002J\b\u0010\u001e\u001a\u00020\u0005H\u0002J\n\u0010 \u001a\u0004\u0018\u00010\u001fH\u0002J\b\u0010!\u001a\u00020\u0005H\u0002J\u0010\u0010#\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\tH\u0002J\b\u0010$\u001a\u00020\u0005H\u0002J\u0018\u0010'\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\tH\u0002J\u0018\u0010*\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0007H\u0016J\b\u0010+\u001a\u00020\u0005H\u0016J\b\u0010,\u001a\u00020\u0005H\u0016J\b\u0010-\u001a\u00020\u0005H\u0016J\b\u0010.\u001a\u00020\u0005H\u0016J\b\u0010/\u001a\u00020\u0005H\u0016J\b\u00100\u001a\u00020\u0005H\u0016J\b\u00102\u001a\u000201H\u0016J\b\u00104\u001a\u000203H\u0016J\u0010\u00107\u001a\u00020\u00022\u0006\u00106\u001a\u000205H\u0016J\u0012\u00108\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u000101H\u0016R\u0018\u0010:\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00109R\u0016\u0010=\u001a\u0004\u0018\u00010;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010<R\u0016\u0010>\u001a\u0004\u0018\u00010;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u0010<R\u0016\u0010@\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010?R\u0016\u0010A\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010?R\u0016\u0010C\u001a\u0002058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010BR\u0016\u00106\u001a\u0002058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010BR\u0018\u0010G\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010J\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010L\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010IR\u0016\u0010N\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010IR\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0014\u0010U\u001a\u00020S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010TR\u0014\u0010X\u001a\u00020V8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010W\u00a8\u0006a"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/floating/TGLiveAnchorFloatingNewView;", "Landroid/widget/FrameLayout;", "Luh4/d;", "Landroid/view/View$OnClickListener;", "Lxh4/a;", "", "o", "", "newStatus", "", "isShowControlPanel", "y", tl.h.F, "nearLeft", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, HippyTKDListViewAdapter.X, "isEnableFreeDrag", "g", "u", "w", "k", ReportConstant.COSTREPORT_PREFIX, "Landroid/content/Context;", "jumpContext", "fromSource", "", "actionCmd", "r", "v", "j", "Landroid/graphics/Bitmap;", "p", "i", "isOn", "t", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "eventId", "isExpose", "l", "centerX", "nearX", "c", "onShow", "onHide", "b", "e", "onBackground", "d", "Landroid/view/View;", "getView", "Luh4/c;", "f", "", "roomId", DomainData.DOMAIN_NAME, NodeProps.ON_CLICK, "Landroid/view/View;", "mRootView", "Lcom/tencent/timi/game/liveroom/impl/room/message/h;", "Lcom/tencent/timi/game/liveroom/impl/room/message/h;", "oneFloatingMessageLayoutManager", "multiFloatingMessageLayoutManager", "I", "curFloatingStatus", "lastFloatingStatus", "J", "ownerId", BdhLogUtil.LogTag.Tag_Conn, "D", "Landroid/graphics/Bitmap;", "privacyBitmap", "E", "Z", "isMicOn", UserInfo.SEX_FEMALE, "isShowOneLine", "G", "isPushMsg", "Ljg4/b;", "H", "Ljg4/b;", "liveRoomService", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "mAegisLog", "Lnr2/ab;", "Lnr2/ab;", "binding", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "K", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class TGLiveAnchorFloatingNewView extends FrameLayout implements uh4.d, View.OnClickListener, xh4.a {
    private static final int L = fh4.b.b(334);
    private static final int M = fh4.b.b(40);
    private static final int N = fh4.b.b(192);
    private static final int P = fh4.b.b(240);
    private static final int Q = fh4.b.b(40);
    private static final int R = fh4.b.b(64);

    /* renamed from: C, reason: from kotlin metadata */
    private long roomId;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Bitmap privacyBitmap;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isMicOn;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isShowOneLine;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isPushMsg;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private jg4.b liveRoomService;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final IAegisLogApi mAegisLog;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final ab binding;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mRootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final com.tencent.timi.game.liveroom.impl.room.message.h oneFloatingMessageLayoutManager;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final com.tencent.timi.game.liveroom.impl.room.message.h multiFloatingMessageLayoutManager;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int curFloatingStatus;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int lastFloatingStatus;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private long ownerId;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TGLiveAnchorFloatingNewView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void A() {
        if (TimiMessagePushDialog.INSTANCE.a()) {
            if (this.isPushMsg) {
                z(this, 2, false, 2, null);
            } else {
                z(this, 4, false, 2, null);
            }
        } else {
            z(this, 4, false, 2, null);
        }
        g(true);
        x();
    }

    private final void g(boolean isEnableFreeDrag) {
        uh4.a.INSTANCE.a().h(String.valueOf(this.roomId), isEnableFreeDrag);
    }

    private final void h(int newStatus, boolean isShowControlPanel) {
        if (newStatus != 1) {
            if (newStatus != 2) {
                if (newStatus != 3) {
                    if (newStatus != 4) {
                        if (newStatus == 5) {
                            View view = this.mRootView;
                            if (view != null) {
                                view.setVisibility(0);
                            }
                            RelativeLayout relativeLayout = this.binding.f420771n;
                            if (relativeLayout != null) {
                                relativeLayout.setVisibility(8);
                            }
                            LinearLayout linearLayout = this.binding.f420770m;
                            if (linearLayout != null) {
                                linearLayout.setVisibility(8);
                            }
                            LinearLayout linearLayout2 = this.binding.f420768k;
                            if (linearLayout2 != null) {
                                linearLayout2.setVisibility(8);
                            }
                            m(true);
                            uh4.a.INSTANCE.a().i(String.valueOf(this.roomId), Q, R);
                            return;
                        }
                        return;
                    }
                    View view2 = this.mRootView;
                    if (view2 != null) {
                        view2.setVisibility(0);
                    }
                    RelativeLayout relativeLayout2 = this.binding.f420771n;
                    if (relativeLayout2 != null) {
                        relativeLayout2.setVisibility(8);
                    }
                    LinearLayout linearLayout3 = this.binding.f420770m;
                    if (linearLayout3 != null) {
                        linearLayout3.setVisibility(8);
                    }
                    m(false);
                    if (isShowControlPanel) {
                        LinearLayout linearLayout4 = this.binding.f420768k;
                        if (linearLayout4 != null) {
                            linearLayout4.setVisibility(0);
                        }
                        q();
                        uh4.a.INSTANCE.a().i(String.valueOf(this.roomId), L, M);
                        return;
                    }
                    LinearLayout linearLayout5 = this.binding.f420768k;
                    if (linearLayout5 != null) {
                        linearLayout5.setVisibility(8);
                    }
                    uh4.a a16 = uh4.a.INSTANCE.a();
                    String valueOf = String.valueOf(this.roomId);
                    int i3 = M;
                    a16.i(valueOf, i3, i3);
                    return;
                }
                View view3 = this.mRootView;
                if (view3 != null) {
                    view3.setVisibility(0);
                }
                RelativeLayout relativeLayout3 = this.binding.f420771n;
                if (relativeLayout3 != null) {
                    relativeLayout3.setVisibility(8);
                }
                LinearLayout linearLayout6 = this.binding.f420770m;
                if (linearLayout6 != null) {
                    linearLayout6.setVisibility(0);
                }
                m(false);
                ViewGroup.LayoutParams layoutParams = null;
                if (isShowControlPanel) {
                    LinearLayout linearLayout7 = this.binding.f420768k;
                    if (linearLayout7 != null) {
                        linearLayout7.setVisibility(0);
                    }
                    q();
                    LinearLayout linearLayout8 = this.binding.f420770m;
                    if (linearLayout8 != null) {
                        layoutParams = linearLayout8.getLayoutParams();
                    }
                    Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                    ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) layoutParams)).topMargin = fh4.b.b(8);
                    uh4.a.INSTANCE.a().i(String.valueOf(this.roomId), L, P);
                    return;
                }
                LinearLayout linearLayout9 = this.binding.f420768k;
                if (linearLayout9 != null) {
                    linearLayout9.setVisibility(8);
                }
                LinearLayout linearLayout10 = this.binding.f420770m;
                if (linearLayout10 != null) {
                    layoutParams = linearLayout10.getLayoutParams();
                }
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) layoutParams)).topMargin = fh4.b.b(0);
                uh4.a.INSTANCE.a().i(String.valueOf(this.roomId), L, N);
                return;
            }
            View view4 = this.mRootView;
            if (view4 != null) {
                view4.setVisibility(0);
            }
            RelativeLayout relativeLayout4 = this.binding.f420771n;
            if (relativeLayout4 != null) {
                relativeLayout4.setVisibility(0);
            }
            LinearLayout linearLayout11 = this.binding.f420770m;
            if (linearLayout11 != null) {
                linearLayout11.setVisibility(8);
            }
            m(false);
            if (isShowControlPanel) {
                LinearLayout linearLayout12 = this.binding.f420768k;
                if (linearLayout12 != null) {
                    linearLayout12.setVisibility(0);
                }
                q();
            } else {
                LinearLayout linearLayout13 = this.binding.f420768k;
                if (linearLayout13 != null) {
                    linearLayout13.setVisibility(8);
                }
            }
            uh4.a.INSTANCE.a().i(String.valueOf(this.roomId), L, M);
            return;
        }
        View view5 = this.mRootView;
        if (view5 != null) {
            view5.setVisibility(8);
        }
    }

    private final void i() {
        IQQLiveAnchorMediaControl iQQLiveAnchorMediaControl;
        ILiveRoom z16 = this.liveRoomService.z(this.roomId);
        if (z16 instanceof IQQLiveAnchorMediaControl) {
            iQQLiveAnchorMediaControl = (IQQLiveAnchorMediaControl) z16;
        } else {
            iQQLiveAnchorMediaControl = null;
        }
        boolean z17 = !this.isMicOn;
        this.mAegisLog.i("Open_Live|TGLiveAnchorFloatingNewView", "doMicIconClick... to[" + z17 + "]");
        if (iQQLiveAnchorMediaControl != null) {
            if (z17) {
                iQQLiveAnchorMediaControl.muteLocalAudio(false);
                gt3.a.b(gt3.a.INSTANCE.a(), "\u9ea6\u514b\u98ce\u5df2\u5f00\u542f", 0, null, 6, null);
            } else {
                iQQLiveAnchorMediaControl.muteLocalAudio(true);
                gt3.a.b(gt3.a.INSTANCE.a(), "\u9ea6\u514b\u98ce\u5df2\u5173\u95ed", 0, null, 6, null);
            }
            this.isMicOn = z17;
            t(z17);
        }
        this.liveRoomService.v1(z17);
    }

    private final void j() {
        IQQLiveAnchorTRTCRoom iQQLiveAnchorTRTCRoom;
        ILiveRoom z16 = this.liveRoomService.z(this.roomId);
        if (z16 instanceof IQQLiveAnchorTRTCRoom) {
            iQQLiveAnchorTRTCRoom = (IQQLiveAnchorTRTCRoom) z16;
        } else {
            iQQLiveAnchorTRTCRoom = null;
        }
        if (iQQLiveAnchorTRTCRoom == null) {
            this.mAegisLog.e("Open_Live|TGLiveAnchorFloatingNewView", "privacy not support - " + this.liveRoomService.z(this.roomId));
            gt3.a.b(gt3.a.INSTANCE.a(), "\u6682\u4e0d\u652f\u6301", 0, null, 6, null);
            return;
        }
        rj4.a aVar = rj4.a.f431587a;
        boolean z17 = !aVar.a();
        this.mAegisLog.i("Open_Live|TGLiveAnchorFloatingNewView", "doPrivacyIconClick... to[" + z17 + "]");
        if (z17) {
            iQQLiveAnchorTRTCRoom.pausePublishStream(p(), 10, false);
            gt3.a.b(gt3.a.INSTANCE.a(), "\u9690\u79c1\u6a21\u5f0f\u5df2\u5f00\u542f\uff0c\u7528\u6237\u65e0\u6cd5\u770b\u5230\u4f60\u7684\u753b\u9762", 0, null, 6, null);
        } else {
            iQQLiveAnchorTRTCRoom.resumePublishStream(false);
            gt3.a.b(gt3.a.INSTANCE.a(), "\u9690\u79c1\u6a21\u5f0f\u5df2\u5173\u95ed\uff0c\u7528\u6237\u53ef\u4ee5\u770b\u5230\u4f60\u7684\u753b\u9762", 0, null, 6, null);
        }
        aVar.b(z17);
        v();
    }

    private final void k() {
        int i3;
        boolean z16 = !this.isPushMsg;
        this.mAegisLog.i("Open_Live|TGLiveAnchorFloatingNewView", "doPushMsgClick... to[" + z16 + "]");
        ImageView imageView = this.binding.f420765h;
        if (imageView != null) {
            if (z16) {
                y(2, true);
                gt3.a.b(gt3.a.INSTANCE.a(), "\u804a\u5929\u7a97\u53e3\u5df2\u5f00\u542f", 0, null, 6, null);
                i3 = R.drawable.o8o;
            } else {
                y(4, true);
                gt3.a.b(gt3.a.INSTANCE.a(), "\u804a\u5929\u7a97\u53e3\u5df2\u5173\u95ed", 0, null, 6, null);
                i3 = R.drawable.o8n;
            }
            imageView.setImageResource(i3);
        }
        this.isPushMsg = z16;
    }

    private final void l(String eventId, boolean isExpose) {
        String str;
        ug4.a aVar = (ug4.a) mm4.b.b(ug4.a.class);
        HashMap hashMap = new HashMap();
        if (isExpose) {
            str = "0";
        } else {
            str = "1";
        }
        hashMap.put("qqlive_action_type", str);
        hashMap.put("qqlive_anchor_id", String.valueOf(this.ownerId));
        hashMap.put("qqlive_room_id", String.valueOf(this.roomId));
        Unit unit = Unit.INSTANCE;
        aVar.reportEvent(eventId, hashMap);
    }

    private final void m(boolean nearLeft) {
        if (nearLeft) {
            this.binding.f420769l.setImageResource(R.drawable.o5b);
            this.binding.f420769l.getLayoutParams().width = Q;
            this.binding.f420769l.getLayoutParams().height = R;
            return;
        }
        this.binding.f420769l.setImageResource(R.drawable.o5a);
        ViewGroup.LayoutParams layoutParams = this.binding.f420769l.getLayoutParams();
        int i3 = Q;
        layoutParams.width = i3;
        this.binding.f420769l.getLayoutParams().height = i3;
    }

    private final void o() {
        ChatFloatingMessageLayout chatFloatingMessageLayout = this.binding.f420760c;
        Intrinsics.checkNotNull(chatFloatingMessageLayout, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.ChatFloatingMessageLayout");
        ChatFloatingMessageLayout chatFloatingMessageLayout2 = this.binding.f420759b;
        Intrinsics.checkNotNull(chatFloatingMessageLayout2, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.ChatFloatingMessageLayout");
        com.tencent.timi.game.liveroom.impl.room.message.h hVar = this.oneFloatingMessageLayoutManager;
        if (hVar != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            hVar.S0(chatFloatingMessageLayout, context, true, true);
        }
        com.tencent.timi.game.liveroom.impl.room.message.h hVar2 = this.multiFloatingMessageLayoutManager;
        if (hVar2 != null) {
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            hVar2.S0(chatFloatingMessageLayout2, context2, true, false);
        }
        l("ev_qqlive_pushmessage_bar", true);
        l("ev_qqlive_pushmessage_moreinfo", true);
    }

    private final Bitmap p() {
        if (this.privacyBitmap == null) {
            int shortWidthPx = ScreenUtils.getShortWidthPx(getContext());
            Bitmap createBitmap = Bitmap.createBitmap(shortWidthPx, ScreenUtils.getLongWidthPx(getContext()), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawColor(-16777216);
            TextPaint textPaint = new TextPaint();
            textPaint.setTextSize(com.tencent.timi.game.utils.b.c(14));
            textPaint.setColor(-1);
            textPaint.setAntiAlias(true);
            StaticLayout staticLayout = new StaticLayout("\u4e3b\u64ad\u6682\u65f6\u79bb\u5f00\uff0c\u5343\u4e07\u522b\u8d70\u5f00\u9a6c\u4e0a\u56de\u6765", textPaint, shortWidthPx, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
            canvas.translate((shortWidthPx - staticLayout.getWidth()) / 2, (r9 - staticLayout.getHeight()) / 2);
            staticLayout.draw(canvas);
            canvas.save();
            canvas.restore();
            this.privacyBitmap = createBitmap;
        }
        return this.privacyBitmap;
    }

    private final void q() {
        l("ev_qqlive_pushmessage_home", true);
        l("ev_qqlive_pushmessage_messagebar", true);
        l("ev_qqlive_pushmessage_microphone", true);
        l("ev_qqlive_pushmessage_picture", true);
    }

    private final void r(Context jumpContext, int fromSource, String actionCmd) {
        ((ni4.a) mm4.b.b(ni4.a.class)).openAnchorRoomPage(jumpContext, fromSource, actionCmd);
    }

    private final void s() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        r(context, 3, null);
    }

    private final void t(boolean isOn) {
        int i3;
        this.mAegisLog.i("Open_Live|TGLiveAnchorFloatingNewView", "refreshMicIcon... current[" + isOn + "]");
        ImageView imageView = this.binding.f420763f;
        if (!isOn) {
            i3 = R.drawable.o8l;
        } else {
            i3 = R.drawable.o8m;
        }
        imageView.setImageResource(i3);
    }

    private final void u() {
        IQQLiveAnchorMediaControl iQQLiveAnchorMediaControl;
        ILiveRoom z16 = this.liveRoomService.z(this.roomId);
        if (z16 instanceof IQQLiveAnchorMediaControl) {
            iQQLiveAnchorMediaControl = (IQQLiveAnchorMediaControl) z16;
        } else {
            iQQLiveAnchorMediaControl = null;
        }
        if (iQQLiveAnchorMediaControl != null) {
            this.isMicOn = !iQQLiveAnchorMediaControl.isMicMuteEnable();
        }
        t(this.isMicOn);
    }

    private final void v() {
        int i3;
        boolean a16 = rj4.a.f431587a.a();
        this.mAegisLog.i("Open_Live|TGLiveAnchorFloatingNewView", "refreshPrivacyIcon... current[" + a16 + "]");
        ImageView imageView = this.binding.f420764g;
        if (!a16) {
            i3 = R.drawable.o8q;
        } else {
            i3 = R.drawable.o8p;
        }
        imageView.setImageResource(i3);
    }

    private final void w() {
        this.binding.f420769l.setOnClickListener(this);
        this.binding.f420767j.setOnClickListener(this);
        this.binding.f420766i.setOnClickListener(this);
        this.binding.f420762e.setOnClickListener(this);
        this.binding.f420765h.setOnClickListener(this);
        this.binding.f420763f.setOnClickListener(this);
        this.binding.f420764g.setOnClickListener(this);
        this.binding.f420761d.setOnClickListener(this);
    }

    private final void x() {
        uh4.a.INSTANCE.a().f(String.valueOf(this.roomId), this);
    }

    private final void y(int newStatus, boolean isShowControlPanel) {
        IAegisLogApi iAegisLogApi = this.mAegisLog;
        TimiMessagePushDialog.Companion companion = TimiMessagePushDialog.INSTANCE;
        iAegisLogApi.i("Open_Live|TGLiveAnchorFloatingNewView", "switchFloatingStatus... hasOpenPushMessage:" + companion.a() + " oldStatus:" + this.curFloatingStatus + " newStatus:" + newStatus + " isShowControlPanel:" + isShowControlPanel);
        if (companion.a()) {
            int i3 = this.curFloatingStatus;
            if (i3 != newStatus) {
                this.lastFloatingStatus = i3;
            }
            this.curFloatingStatus = newStatus;
            h(newStatus, isShowControlPanel);
            return;
        }
        if (newStatus == 4 || newStatus == 5) {
            int i16 = this.curFloatingStatus;
            if (i16 != newStatus) {
                this.lastFloatingStatus = i16;
            }
            this.curFloatingStatus = newStatus;
            h(newStatus, false);
        }
    }

    static /* synthetic */ void z(TGLiveAnchorFloatingNewView tGLiveAnchorFloatingNewView, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            z16 = false;
        }
        tGLiveAnchorFloatingNewView.y(i3, z16);
    }

    @Override // uh4.d
    @NotNull
    /* renamed from: a */
    public uh4.b getFloatingAnimateInfo() {
        return d.a.a(this);
    }

    @Override // uh4.d
    public void b() {
        this.mAegisLog.i("Open_Live|TGLiveAnchorFloatingNewView", "onAttachFloat");
    }

    @Override // xh4.a
    public void c(int centerX, int nearX) {
        if (nearX < 0 && Math.abs(nearX) - Math.abs(centerX) < 10) {
            y(5, false);
        } else if (this.curFloatingStatus == 5 && Math.abs(nearX) - Math.abs(centerX) >= 10) {
            y(this.lastFloatingStatus, false);
        }
    }

    @Override // uh4.d
    public void d() {
        this.mAegisLog.i("Open_Live|TGLiveAnchorFloatingNewView", "onForground");
    }

    @Override // uh4.d
    public void e() {
        this.mAegisLog.i("Open_Live|TGLiveAnchorFloatingNewView", "onDetachFloat");
    }

    @Override // uh4.d
    @NotNull
    public uh4.c f() {
        return new c.a().e(L, M).a();
    }

    @NotNull
    public uh4.d n(long roomId) {
        long j3;
        this.roomId = roomId;
        QQLiveAnchorRoomInfo x16 = this.liveRoomService.x(roomId);
        if (x16 != null) {
            j3 = x16.uid;
        } else {
            j3 = 0;
        }
        this.ownerId = j3;
        this.mAegisLog.i("Open_Live|TGLiveAnchorFloatingNewView", "init... roomId:" + roomId + " ownerId:" + j3);
        return this;
    }

    @Override // uh4.d
    public void onBackground() {
        this.mAegisLog.i("Open_Live|TGLiveAnchorFloatingNewView", "onBackground");
        A();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            num = Integer.valueOf(v3.getId());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == R.id.f6366345) {
            if (!com.tencent.timi.game.utils.o.c("qqlive_floating_change_show_msg_up")) {
                z(this, 2, false, 2, null);
                l("ev_qqlive_pushmessage_moreinfo", false);
            }
        } else if (num != null && num.intValue() == R.id.f6365344) {
            if (!com.tencent.timi.game.utils.o.c("qqlive_floating_change_show_msg_down")) {
                z(this, 3, false, 2, null);
            }
        } else if (num != null && num.intValue() == R.id.f634633l) {
            if (!com.tencent.timi.game.utils.o.c("qqlive_anchor_floating_btn_push_msg")) {
                k();
                l("ev_qqlive_pushmessage_messagebar", false);
            }
        } else if (num != null && num.intValue() == R.id.f634333i) {
            if (!com.tencent.timi.game.utils.o.c("qqlive_anchor_floating_btn_go_main")) {
                s();
                l("ev_qqlive_pushmessage_home", false);
            }
        } else if (num != null && num.intValue() == R.id.f634433j) {
            if (!com.tencent.timi.game.utils.o.c("qqlive_anchor_floating_btn_mic")) {
                i();
                l("ev_qqlive_pushmessage_microphone", false);
            }
        } else if (num != null && num.intValue() == R.id.f634533k) {
            if (!com.tencent.timi.game.utils.o.c("qqlive_anchor_floating_btn_privacy")) {
                j();
                l("ev_qqlive_pushmessage_picture", false);
            }
        } else if (num != null && num.intValue() == R.id.f6368347) {
            if (!com.tencent.timi.game.utils.o.c("qqlive_floating_icon")) {
                if (TimiMessagePushDialog.INSTANCE.a()) {
                    y(this.curFloatingStatus, true);
                } else if (this.curFloatingStatus == 4) {
                    s();
                }
                l("ev_qqlive_pushmessage_bar", false);
            }
        } else if (num != null && num.intValue() == R.id.f634233h && !com.tencent.timi.game.utils.o.c("qqlive_anchor_floating_btn_close")) {
            y(this.curFloatingStatus, false);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // uh4.d
    public void onHide() {
        this.mAegisLog.i("Open_Live|TGLiveAnchorFloatingNewView", "onHide");
        com.tencent.timi.game.liveroom.impl.room.message.h hVar = this.oneFloatingMessageLayoutManager;
        if (hVar != null) {
            hVar.unregister();
        }
        com.tencent.timi.game.liveroom.impl.room.message.h hVar2 = this.multiFloatingMessageLayoutManager;
        if (hVar2 != null) {
            hVar2.unregister();
        }
        com.tencent.timi.game.liveroom.impl.room.message.h hVar3 = this.oneFloatingMessageLayoutManager;
        if (hVar3 != null) {
            hVar3.U0(this.roomId);
        }
        com.tencent.timi.game.liveroom.impl.room.message.h hVar4 = this.multiFloatingMessageLayoutManager;
        if (hVar4 != null) {
            hVar4.U0(this.roomId);
        }
    }

    @Override // uh4.d
    public void onShow() {
        long j3;
        boolean isAppOnForeground = BaseGesturePWDUtil.isAppOnForeground(getContext());
        this.mAegisLog.i("Open_Live|TGLiveAnchorFloatingNewView", "onShow, isForeground: " + isAppOnForeground);
        TGLiveClientQIPCModule.INSTANCE.c().registerModule();
        com.tencent.timi.game.liveroom.impl.room.message.h hVar = this.oneFloatingMessageLayoutManager;
        if (hVar != null) {
            hVar.L0(this.roomId);
        }
        com.tencent.timi.game.liveroom.impl.room.message.h hVar2 = this.multiFloatingMessageLayoutManager;
        if (hVar2 != null) {
            hVar2.L0(this.roomId);
        }
        com.tencent.timi.game.liveroom.impl.room.message.h hVar3 = this.oneFloatingMessageLayoutManager;
        if (hVar3 != null) {
            hVar3.register();
        }
        com.tencent.timi.game.liveroom.impl.room.message.h hVar4 = this.multiFloatingMessageLayoutManager;
        if (hVar4 != null) {
            hVar4.register();
        }
        com.tencent.timi.game.liveroom.impl.room.message.h hVar5 = this.oneFloatingMessageLayoutManager;
        long j16 = 0;
        if (hVar5 != null) {
            long j17 = this.roomId;
            jg4.h n3 = this.liveRoomService.n(j17);
            if (n3 != null) {
                j3 = n3.f409907a;
            } else {
                j3 = 0;
            }
            hVar5.V0(j17, j3, 1, true);
        }
        com.tencent.timi.game.liveroom.impl.room.message.h hVar6 = this.multiFloatingMessageLayoutManager;
        if (hVar6 != null) {
            long j18 = this.roomId;
            jg4.h n16 = this.liveRoomService.n(j18);
            if (n16 != null) {
                j16 = n16.f409907a;
            }
            hVar6.V0(j18, j16, 1, false);
        }
        v();
        u();
        A();
    }

    @Override // uh4.d
    public void setLaunchParam(@Nullable Object obj) {
        d.a.b(this, obj);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TGLiveAnchorFloatingNewView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ TGLiveAnchorFloatingNewView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TGLiveAnchorFloatingNewView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.oneFloatingMessageLayoutManager = new com.tencent.timi.game.liveroom.impl.room.message.h();
        this.multiFloatingMessageLayoutManager = new com.tencent.timi.game.liveroom.impl.room.message.h();
        this.isMicOn = true;
        this.isShowOneLine = true;
        this.isPushMsg = true;
        mm4.a b16 = mm4.b.b(jg4.b.class);
        Intrinsics.checkNotNullExpressionValue(b16, "getService(ITgLiveRoomService::class.java)");
        this.liveRoomService = (jg4.b) b16;
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.mAegisLog = (IAegisLogApi) api;
        ab g16 = ab.g(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.binding = g16;
        this.mRootView = g16.getMRv();
        o();
        w();
        z(this, 1, false, 2, null);
    }

    @Override // uh4.d
    @NotNull
    public View getView() {
        return this;
    }
}
