package com.tencent.robot.discover.adapter.section;

import android.app.Activity;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.widget.qqui.RoundRectImageView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.report.MiniAppSearchDtReportHelper;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotBaseInfo;
import com.tencent.qqnt.kernel.nativeinterface.ISetAddRobotToGroupCallback;
import com.tencent.qqnt.kernel.nativeinterface.RobotBase;
import com.tencent.robot.profile.api.IRobotProfileCardApi;
import com.tencent.robot.relation.api.IRobotRelationService;
import h44.OpenRobotProfileCardArgs;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u000b2\u00020\u0001:\u0001FB\u0007\u00a2\u0006\u0004\bD\u0010EJ\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u0012\u0010\r\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u0013\u001a\u00020\t2\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0010j\b\u0012\u0004\u0012\u00020\u0005`\u0011H\u0002J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0014J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0019H\u0014J(\u0010!\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001d2\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001fH\u0014R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\"\u00105\u001a\u00020.8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010:\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u00100R\u0016\u0010<\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u00100R\u0016\u0010>\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u00100R\u0016\u0010@\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u00100R\u0018\u0010C\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010B\u00a8\u0006G"}, d2 = {"Lcom/tencent/robot/discover/adapter/section/RobotContentSection;", "Lcom/tencent/robot/discover/adapter/section/e;", "Lk34/d;", "data", "", "", "", "w", "robotUin", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "H", "errorMsg", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "G", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "labels", "L", "", "add", "K", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "Lk34/a;", "", "position", "", "payload", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/widget/qqui/RoundRectImageView;", "e", "Lcom/tencent/mobileqq/guild/widget/qqui/RoundRectImageView;", "mAvatar", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "mRedDot", "Lcom/tencent/biz/qui/quibutton/QUIButton;", tl.h.F, "Lcom/tencent/biz/qui/quibutton/QUIButton;", "mAddButton", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", HippyTKDListViewAdapter.X, "()Landroid/widget/TextView;", "J", "(Landroid/widget/TextView;)V", "mTitleText", "Landroid/view/ViewGroup;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/ViewGroup;", "mLabelContainer", "mLabel1", "D", "mLabel2", "E", "mLabel3", UserInfo.SEX_FEMALE, "mDescText", "Ll34/c;", "Ll34/c;", "mRobotItemListener", "<init>", "()V", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public class RobotContentSection extends e {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView mLabel1;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView mLabel2;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView mLabel3;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView mDescText;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private l34.c mRobotItemListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RoundRectImageView mAvatar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView mRedDot;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QUIButton mAddButton;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public TextView mTitleText;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mLabelContainer;

    private final void A(final k34.d data, final String robotUin) {
        IRuntimeService iRuntimeService;
        if (!AppNetConnInfo.isNetSupport()) {
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.ci7, 0).show();
            return;
        }
        H(robotUin);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            iRuntimeService = peekAppRuntime.getRuntimeService(IRobotRelationService.class, "");
        } else {
            iRuntimeService = null;
        }
        IRobotRelationService iRobotRelationService = (IRobotRelationService) iRuntimeService;
        if (iRobotRelationService != null) {
            String troopUin = data.getTroopUin();
            GroupRobotBaseInfo groupRobotBaseInfo = new GroupRobotBaseInfo();
            groupRobotBaseInfo.robotUin = Util.toLongOrDefault(robotUin, 0L);
            groupRobotBaseInfo.robotName = data.getCom.tencent.mobileqq.troop.robot.api.IRobotUtilApi.MMKV_SCENE_ID java.lang.String().baseInfo.robotName;
            groupRobotBaseInfo.robotAvatar = data.getCom.tencent.mobileqq.troop.robot.api.IRobotUtilApi.MMKV_SCENE_ID java.lang.String().baseInfo.robotAvatar;
            groupRobotBaseInfo.robotDesc = data.getCom.tencent.mobileqq.troop.robot.api.IRobotUtilApi.MMKV_SCENE_ID java.lang.String().baseInfo.robotDesc;
            Unit unit = Unit.INSTANCE;
            iRobotRelationService.addRobotToTroop(robotUin, troopUin, groupRobotBaseInfo, new ISetAddRobotToGroupCallback() { // from class: com.tencent.robot.discover.adapter.section.h
                @Override // com.tencent.qqnt.kernel.nativeinterface.ISetAddRobotToGroupCallback
                public final void onResult(int i3, String str) {
                    RobotContentSection.B(robotUin, data, this, i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(String robotUin, k34.d data, RobotContentSection this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(robotUin, "$robotUin");
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("RobotContentSection", 1, "onAddButtonClick " + i3 + " " + str + " " + robotUin + " " + data.getTroopUin());
        if (i3 == 0) {
            this$0.z();
        } else {
            this$0.y(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(RobotContentSection this$0, String robotUin, k34.a data, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(robotUin, "$robotUin");
        Intrinsics.checkNotNullParameter(data, "$data");
        this$0.G(robotUin, (k34.d) data);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(final RobotContentSection this$0, RobotBase robotInfo, final k34.a data, String robotUin, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(robotUin, "$robotUin");
        l34.c cVar = this$0.mRobotItemListener;
        if (cVar != null) {
            Intrinsics.checkNotNullExpressionValue(robotInfo, "robotInfo");
            cVar.i1(robotInfo, new Function0<Unit>() { // from class: com.tencent.robot.discover.adapter.section.RobotContentSection$onBindData$2$1
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
                    ((k34.d) k34.a.this).f(true);
                    this$0.K(true);
                }
            });
        }
        this$0.A((k34.d) data, robotUin);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void G(String robotUin, k34.d data) {
        boolean z16;
        if (FastClickUtils.isFastDoubleClick("RobotContentSection")) {
            return;
        }
        Activity p16 = p();
        Intrinsics.checkNotNull(p16);
        ((IRobotProfileCardApi) QRoute.api(IRobotProfileCardApi.class)).openRobotProfileCard(new OpenRobotProfileCardArgs(p16, robotUin, data.getTroopUin(), 1, 0, null, 48, null));
        ImageView imageView = this.mRedDot;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRedDot");
            imageView = null;
        }
        if (imageView.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            n34.d.f418126a.c(robotUin);
            ImageView imageView3 = this.mRedDot;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRedDot");
            } else {
                imageView2 = imageView3;
            }
            imageView2.setVisibility(8);
        }
        l34.c cVar = this.mRobotItemListener;
        if (cVar != null) {
            cVar.B2(robotUin, z16);
        }
        ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "", "0X8009F9F", 0, 0, robotUin, "", "", "");
    }

    private final void H(String robotUin) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        ReportController.o((AppInterface) peekAppRuntime, "dc00898", "", "", "", "0X8009FA0", 0, 0, robotUin, "", "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(boolean add) {
        QUIButton qUIButton = null;
        if (add) {
            QUIButton qUIButton2 = this.mAddButton;
            if (qUIButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAddButton");
                qUIButton2 = null;
            }
            qUIButton2.setEnabled(false);
            QUIButton qUIButton3 = this.mAddButton;
            if (qUIButton3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAddButton");
                qUIButton3 = null;
            }
            qUIButton3.setClickable(false);
            QUIButton qUIButton4 = this.mAddButton;
            if (qUIButton4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAddButton");
                qUIButton4 = null;
            }
            qUIButton4.setText("\u5df2\u6dfb\u52a0");
            QUIButton qUIButton5 = this.mAddButton;
            if (qUIButton5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAddButton");
                qUIButton5 = null;
            }
            qUIButton5.setOnClickListener(null);
            return;
        }
        QUIButton qUIButton6 = this.mAddButton;
        if (qUIButton6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddButton");
            qUIButton6 = null;
        }
        qUIButton6.setEnabled(true);
        QUIButton qUIButton7 = this.mAddButton;
        if (qUIButton7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddButton");
            qUIButton7 = null;
        }
        qUIButton7.setClickable(true);
        QUIButton qUIButton8 = this.mAddButton;
        if (qUIButton8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddButton");
        } else {
            qUIButton = qUIButton8;
        }
        qUIButton.setText("\u6dfb\u52a0");
    }

    private final void L(ArrayList<String> labels) {
        int i3;
        ViewGroup viewGroup = this.mLabelContainer;
        TextView textView = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLabelContainer");
            viewGroup = null;
        }
        if (!labels.isEmpty()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        viewGroup.setVisibility(i3);
        TextView textView2 = this.mLabel1;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLabel1");
            textView2 = null;
        }
        textView2.setVisibility(8);
        TextView textView3 = this.mLabel2;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLabel2");
            textView3 = null;
        }
        textView3.setVisibility(8);
        TextView textView4 = this.mLabel3;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLabel3");
            textView4 = null;
        }
        textView4.setVisibility(8);
        if (labels.size() > 0) {
            TextView textView5 = this.mLabel1;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLabel1");
                textView5 = null;
            }
            textView5.setVisibility(0);
            TextView textView6 = this.mLabel1;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLabel1");
                textView6 = null;
            }
            textView6.setText(labels.get(0));
        }
        if (labels.size() > 1) {
            TextView textView7 = this.mLabel2;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLabel2");
                textView7 = null;
            }
            textView7.setVisibility(0);
            TextView textView8 = this.mLabel2;
            if (textView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLabel2");
                textView8 = null;
            }
            textView8.setText(labels.get(1));
        }
        if (labels.size() > 2) {
            TextView textView9 = this.mLabel3;
            if (textView9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLabel3");
                textView9 = null;
            }
            textView9.setVisibility(0);
            TextView textView10 = this.mLabel3;
            if (textView10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLabel3");
            } else {
                textView = textView10;
            }
            textView.setText(labels.get(2));
        }
    }

    private final Map<String, Object> w(k34.d data) {
        Map<String, Object> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("bot_name", data.getCom.tencent.mobileqq.troop.robot.api.IRobotUtilApi.MMKV_SCENE_ID java.lang.String().baseInfo.robotName), TuplesKt.to("bot_uin", Long.valueOf(data.getCom.tencent.mobileqq.troop.robot.api.IRobotUtilApi.MMKV_SCENE_ID java.lang.String().baseInfo.robotUin)), TuplesKt.to("rank", Integer.valueOf(data.getRank())), TuplesKt.to(MiniAppSearchDtReportHelper.DT_ELEMENT_CLASSIFICATION_NAME, data.getCategoryName()));
        return mapOf;
    }

    private final void y(String errorMsg) {
        boolean z16;
        if (errorMsg != null && errorMsg.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            errorMsg = BaseApplication.getContext().getString(R.string.f222136cp);
        }
        Intrinsics.checkNotNullExpressionValue(errorMsg, "if (errorMsg.isNullOrEmp\u2026add_failed) else errorMsg");
        QQToast.makeText(BaseApplication.getContext(), 1, errorMsg, 0).show();
    }

    private final void z() {
        QQToast.makeText(BaseApplication.getContext(), 2, R.string.f222266d2, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public void onBindData(@NotNull final k34.a data, int position, @Nullable List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (data instanceof k34.d) {
            k34.d dVar = (k34.d) data;
            final RobotBase robotBase = dVar.getCom.tencent.mobileqq.troop.robot.api.IRobotUtilApi.MMKV_SCENE_ID java.lang.String().baseInfo;
            n34.c cVar = n34.c.f418125a;
            String valueOf = String.valueOf(robotBase.robotUin);
            RoundRectImageView roundRectImageView = this.mAvatar;
            QUIButton qUIButton = null;
            if (roundRectImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAvatar");
                roundRectImageView = null;
            }
            cVar.a(valueOf, roundRectImageView);
            x().setText(robotBase.robotName);
            int i3 = 8;
            if (TextUtils.isEmpty(robotBase.robotDesc)) {
                TextView textView = this.mDescText;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDescText");
                    textView = null;
                }
                textView.setVisibility(8);
            } else {
                TextView textView2 = this.mDescText;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDescText");
                    textView2 = null;
                }
                textView2.setVisibility(0);
                TextView textView3 = this.mDescText;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDescText");
                    textView3 = null;
                }
                textView3.setText(Html.fromHtml(robotBase.robotDesc));
            }
            ArrayList<String> arrayList = dVar.getCom.tencent.mobileqq.troop.robot.api.IRobotUtilApi.MMKV_SCENE_ID java.lang.String().labels;
            Intrinsics.checkNotNullExpressionValue(arrayList, "data.robot.labels");
            L(arrayList);
            K(dVar.getIsAdded());
            final String valueOf2 = String.valueOf(dVar.getCom.tencent.mobileqq.troop.robot.api.IRobotUtilApi.MMKV_SCENE_ID java.lang.String().baseInfo.robotUin);
            n34.d dVar2 = n34.d.f418126a;
            ImageView imageView = this.mRedDot;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRedDot");
                imageView = null;
            }
            dVar2.a(imageView, dVar.getTroopUin(), valueOf2);
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.discover.adapter.section.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RobotContentSection.D(RobotContentSection.this, valueOf2, data, view);
                }
            });
            if (!dVar.getIsAdded()) {
                QUIButton qUIButton2 = this.mAddButton;
                if (qUIButton2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAddButton");
                    qUIButton2 = null;
                }
                qUIButton2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.discover.adapter.section.g
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        RobotContentSection.F(RobotContentSection.this, robotBase, data, valueOf2, view);
                    }
                });
            }
            QUIButton qUIButton3 = this.mAddButton;
            if (qUIButton3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAddButton");
                qUIButton3 = null;
            }
            if (com.tencent.robot.profile.data.g.INSTANCE.b(dVar.getTroopUin())) {
                i3 = 0;
            }
            qUIButton3.setVisibility(i3);
            QUIButton qUIButton4 = this.mAddButton;
            if (qUIButton4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAddButton");
            } else {
                qUIButton = qUIButton4;
            }
            q(qUIButton, "em_qqrobot_add_robot", w(dVar));
            q(this.mRootView, "em_bas_robot_articles", w(dVar));
        }
    }

    public final void J(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.mTitleText = textView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.f7627418);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.robot_avatar)");
        this.mAvatar = (RoundRectImageView) findViewById;
        View findViewById2 = containerView.findViewById(R.id.f763241c);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026.id.robot_avatar_red_dot)");
        this.mRedDot = (ImageView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.f7619410);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewById(R.id.robot_add_button)");
        this.mAddButton = (QUIButton) findViewById3;
        View findViewById4 = containerView.findViewById(R.id.f775744q);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewById(R.id.robot_title)");
        J((TextView) findViewById4);
        View findViewById5 = containerView.findViewById(R.id.f769042x);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "containerView.findViewById(R.id.robot_label_ll)");
        this.mLabelContainer = (ViewGroup) findViewById5;
        View findViewById6 = containerView.findViewById(R.id.f768742u);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "containerView.findViewById(R.id.robot_label_1)");
        this.mLabel1 = (TextView) findViewById6;
        View findViewById7 = containerView.findViewById(R.id.f768842v);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "containerView.findViewById(R.id.robot_label_2)");
        this.mLabel2 = (TextView) findViewById7;
        View findViewById8 = containerView.findViewById(R.id.f768942w);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "containerView.findViewById(R.id.robot_label_3)");
        this.mLabel3 = (TextView) findViewById8;
        View findViewById9 = containerView.findViewById(R.id.f765141v);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "containerView.findViewById(R.id.robot_desc)");
        this.mDescText = (TextView) findViewById9;
        QUIButton qUIButton = this.mAddButton;
        RoundRectImageView roundRectImageView = null;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddButton");
            qUIButton = null;
        }
        qUIButton.setPadding(0, 0, 0, 0);
        RoundRectImageView roundRectImageView2 = this.mAvatar;
        if (roundRectImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAvatar");
        } else {
            roundRectImageView = roundRectImageView2;
        }
        roundRectImageView.setCornerRadiusAndMode(this.mRootView.getResources().getDimensionPixelSize(R.dimen.c_7), 1);
        View mRootView = this.mRootView;
        Intrinsics.checkNotNullExpressionValue(mRootView, "mRootView");
        this.mRobotItemListener = l34.e.c(mRootView);
    }

    @NotNull
    public final TextView x() {
        TextView textView = this.mTitleText;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mTitleText");
        return null;
    }
}
