package com.tencent.robot.discover.adapter.section;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.widget.qqui.RoundRectImageView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.troop.robot.api.IRobotUtilApi;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.RobotBase;
import com.tencent.robot.discover.fragment.TroopRobotAddedFragment;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b4\u00105J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J(\u0010\u000f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0014J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0014J(\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00162\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018H\u0014J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u001e\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000bH\u0016R\u0016\u0010!\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010'R\u0016\u0010,\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010'R\u0016\u0010/\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u0010.R\u0016\u00103\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u0010.\u00a8\u00066"}, d2 = {"Lcom/tencent/robot/discover/adapter/section/b;", "Lcom/tencent/robot/discover/adapter/section/e;", "Ll34/a;", "Lk34/b;", "data", "", "w", "Lcom/tencent/mobileqq/guild/widget/qqui/RoundRectImageView;", "avatar", "Landroid/widget/ImageView;", "redDot", "", "troopUin", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotBase;", IRobotUtilApi.MMKV_SCENE_ID, "v", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "Lk34/a;", "", "position", "", "", "payload", "t", "o", "robotUin", "c", "e", "Landroid/view/View;", "mContainView", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "mAddText", tl.h.F, "Lcom/tencent/mobileqq/guild/widget/qqui/RoundRectImageView;", "mAvatar1", "i", "mAvatar2", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mAvatar3", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/ImageView;", "mRedDot1", "D", "mRedDot2", "E", "mRedDot3", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b extends e implements l34.a {

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView mRedDot1;

    /* renamed from: D, reason: from kotlin metadata */
    private ImageView mRedDot2;

    /* renamed from: E, reason: from kotlin metadata */
    private ImageView mRedDot3;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View mContainView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView mAddText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RoundRectImageView mAvatar1;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private RoundRectImageView mAvatar2;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private RoundRectImageView mAvatar3;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(k34.a data, b this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        k34.b bVar = (k34.b) data;
        TroopRobotAddedFragment.INSTANCE.a(bVar.getTroopUin(), bVar.getMaxNum(), bVar.a(), this$0.p());
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void v(RoundRectImageView avatar, ImageView redDot, String troopUin, RobotBase robot) {
        avatar.setVisibility(0);
        n34.c.f418125a.a(String.valueOf(robot.robotUin), avatar);
        n34.d.f418126a.a(redDot, troopUin, String.valueOf(robot.robotUin));
    }

    private final void w(k34.b data) {
        int size = data.a().size();
        View view = this.mContainView;
        ImageView imageView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainView");
            view = null;
        }
        view.setVisibility(0);
        TextView textView = this.mAddText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddText");
            textView = null;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String qqStr = HardCodeUtil.qqStr(R.string.f222286d4);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.robot_discovery_add_txt)");
        String format = String.format(qqStr, Arrays.copyOf(new Object[]{Integer.valueOf(size), Integer.valueOf(data.getMaxNum())}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        textView.setText(format);
        String troopUin = data.getTroopUin();
        if (size >= 3) {
            RoundRectImageView roundRectImageView = this.mAvatar3;
            if (roundRectImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAvatar3");
                roundRectImageView = null;
            }
            ImageView imageView2 = this.mRedDot3;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRedDot3");
                imageView2 = null;
            }
            RobotBase robotBase = data.a().get(0);
            Intrinsics.checkNotNullExpressionValue(robotBase, "data.addedRobots[0]");
            v(roundRectImageView, imageView2, troopUin, robotBase);
            RoundRectImageView roundRectImageView2 = this.mAvatar2;
            if (roundRectImageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAvatar2");
                roundRectImageView2 = null;
            }
            ImageView imageView3 = this.mRedDot2;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRedDot2");
                imageView3 = null;
            }
            RobotBase robotBase2 = data.a().get(1);
            Intrinsics.checkNotNullExpressionValue(robotBase2, "data.addedRobots[1]");
            v(roundRectImageView2, imageView3, troopUin, robotBase2);
            RoundRectImageView roundRectImageView3 = this.mAvatar1;
            if (roundRectImageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAvatar1");
                roundRectImageView3 = null;
            }
            ImageView imageView4 = this.mRedDot1;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRedDot1");
            } else {
                imageView = imageView4;
            }
            RobotBase robotBase3 = data.a().get(2);
            Intrinsics.checkNotNullExpressionValue(robotBase3, "data.addedRobots[2]");
            v(roundRectImageView3, imageView, troopUin, robotBase3);
            return;
        }
        if (size >= 2) {
            RoundRectImageView roundRectImageView4 = this.mAvatar3;
            if (roundRectImageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAvatar3");
                roundRectImageView4 = null;
            }
            roundRectImageView4.setVisibility(8);
            RoundRectImageView roundRectImageView5 = this.mAvatar2;
            if (roundRectImageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAvatar2");
                roundRectImageView5 = null;
            }
            ImageView imageView5 = this.mRedDot2;
            if (imageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRedDot2");
                imageView5 = null;
            }
            RobotBase robotBase4 = data.a().get(0);
            Intrinsics.checkNotNullExpressionValue(robotBase4, "data.addedRobots[0]");
            v(roundRectImageView5, imageView5, troopUin, robotBase4);
            RoundRectImageView roundRectImageView6 = this.mAvatar1;
            if (roundRectImageView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAvatar1");
                roundRectImageView6 = null;
            }
            ImageView imageView6 = this.mRedDot1;
            if (imageView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRedDot1");
            } else {
                imageView = imageView6;
            }
            RobotBase robotBase5 = data.a().get(1);
            Intrinsics.checkNotNullExpressionValue(robotBase5, "data.addedRobots[1]");
            v(roundRectImageView6, imageView, troopUin, robotBase5);
            return;
        }
        if (size >= 1) {
            RoundRectImageView roundRectImageView7 = this.mAvatar3;
            if (roundRectImageView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAvatar3");
                roundRectImageView7 = null;
            }
            roundRectImageView7.setVisibility(8);
            RoundRectImageView roundRectImageView8 = this.mAvatar2;
            if (roundRectImageView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAvatar2");
                roundRectImageView8 = null;
            }
            roundRectImageView8.setVisibility(8);
            RoundRectImageView roundRectImageView9 = this.mAvatar1;
            if (roundRectImageView9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAvatar1");
                roundRectImageView9 = null;
            }
            ImageView imageView7 = this.mRedDot1;
            if (imageView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRedDot1");
            } else {
                imageView = imageView7;
            }
            RobotBase robotBase6 = data.a().get(0);
            Intrinsics.checkNotNullExpressionValue(robotBase6, "data.addedRobots[0]");
            v(roundRectImageView9, imageView, troopUin, robotBase6);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // l34.a
    public void c(@NotNull String troopUin, @NotNull String robotUin) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        T t16 = this.mData;
        if (t16 instanceof k34.b) {
            Intrinsics.checkNotNull(t16, "null cannot be cast to non-null type com.tencent.robot.discover.data.RobotAddBlockData");
            if (Intrinsics.areEqual(((k34.b) t16).getTroopUin(), troopUin)) {
                ImageView imageView = this.mRedDot1;
                ImageView imageView2 = null;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRedDot1");
                    imageView = null;
                }
                if (Intrinsics.areEqual(imageView.getTag(), robotUin)) {
                    ImageView imageView3 = this.mRedDot1;
                    if (imageView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mRedDot1");
                        imageView3 = null;
                    }
                    imageView3.setVisibility(8);
                }
                ImageView imageView4 = this.mRedDot2;
                if (imageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRedDot2");
                    imageView4 = null;
                }
                if (Intrinsics.areEqual(imageView4.getTag(), robotUin)) {
                    ImageView imageView5 = this.mRedDot2;
                    if (imageView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mRedDot2");
                        imageView5 = null;
                    }
                    imageView5.setVisibility(8);
                }
                ImageView imageView6 = this.mRedDot3;
                if (imageView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRedDot3");
                    imageView6 = null;
                }
                if (Intrinsics.areEqual(imageView6.getTag(), robotUin)) {
                    ImageView imageView7 = this.mRedDot3;
                    if (imageView7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mRedDot3");
                    } else {
                        imageView2 = imageView7;
                    }
                    imageView2.setVisibility(8);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // l34.a
    public void o(@NotNull RobotBase robot) {
        Intrinsics.checkNotNullParameter(robot, "robot");
        T t16 = this.mData;
        if (t16 instanceof k34.b) {
            Intrinsics.checkNotNull(t16, "null cannot be cast to non-null type com.tencent.robot.discover.data.RobotAddBlockData");
            k34.b bVar = (k34.b) t16;
            bVar.a().add(0, robot);
            w(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.f7738448);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.robot_rootView)");
        this.mContainView = findViewById;
        View findViewById2 = containerView.findViewById(R.id.f7621412);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewById(R.id.robot_add_text)");
        this.mAddText = (TextView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.f7628419);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewById(R.id.robot_avatar_1)");
        this.mAvatar1 = (RoundRectImageView) findViewById3;
        View findViewById4 = containerView.findViewById(R.id.f762941_);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewById(R.id.robot_avatar_2)");
        this.mAvatar2 = (RoundRectImageView) findViewById4;
        View findViewById5 = containerView.findViewById(R.id.f763041a);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "containerView.findViewById(R.id.robot_avatar_3)");
        this.mAvatar3 = (RoundRectImageView) findViewById5;
        View findViewById6 = containerView.findViewById(R.id.f763341d);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "containerView.findViewBy\u2026d.robot_avatar_red_dot_1)");
        this.mRedDot1 = (ImageView) findViewById6;
        View findViewById7 = containerView.findViewById(R.id.f763441e);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "containerView.findViewBy\u2026d.robot_avatar_red_dot_2)");
        this.mRedDot2 = (ImageView) findViewById7;
        View findViewById8 = containerView.findViewById(R.id.f763541f);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "containerView.findViewBy\u2026d.robot_avatar_red_dot_3)");
        this.mRedDot3 = (ImageView) findViewById8;
        RoundRectImageView roundRectImageView = this.mAvatar1;
        RoundRectImageView roundRectImageView2 = null;
        if (roundRectImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAvatar1");
            roundRectImageView = null;
        }
        roundRectImageView.setVisibility(8);
        RoundRectImageView roundRectImageView3 = this.mAvatar2;
        if (roundRectImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAvatar2");
            roundRectImageView3 = null;
        }
        roundRectImageView3.setVisibility(8);
        RoundRectImageView roundRectImageView4 = this.mAvatar3;
        if (roundRectImageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAvatar3");
            roundRectImageView4 = null;
        }
        roundRectImageView4.setVisibility(8);
        int dimensionPixelSize = this.mRootView.getResources().getDimensionPixelSize(R.dimen.c9y);
        RoundRectImageView roundRectImageView5 = this.mAvatar1;
        if (roundRectImageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAvatar1");
            roundRectImageView5 = null;
        }
        roundRectImageView5.setCornerRadiusAndMode(dimensionPixelSize, 1);
        RoundRectImageView roundRectImageView6 = this.mAvatar2;
        if (roundRectImageView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAvatar2");
            roundRectImageView6 = null;
        }
        roundRectImageView6.setCornerRadiusAndMode(dimensionPixelSize, 1);
        RoundRectImageView roundRectImageView7 = this.mAvatar3;
        if (roundRectImageView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAvatar3");
        } else {
            roundRectImageView2 = roundRectImageView7;
        }
        roundRectImageView2.setCornerRadiusAndMode(dimensionPixelSize, 1);
        View mRootView = this.mRootView;
        Intrinsics.checkNotNullExpressionValue(mRootView, "mRootView");
        l34.e.e(mRootView, this);
        e.r(this, this.mRootView, "em_qqrobot_added_robot", null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void onBindData(@NotNull final k34.a data, int position, @Nullable List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (data instanceof k34.b) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.discover.adapter.section.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    b.u(k34.a.this, this, view);
                }
            });
            k34.b bVar = (k34.b) data;
            if (bVar.a().isEmpty()) {
                View view = this.mContainView;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContainView");
                    view = null;
                }
                view.setVisibility(8);
                return;
            }
            w(bVar);
        }
    }
}
