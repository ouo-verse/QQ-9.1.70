package com.tencent.state.square.chatland.setting;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.square.EntranceLink;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.api.ISquarePagView;
import com.tencent.state.square.api.ISquareTaskServiceKt;
import com.tencent.state.square.api.TaskItem;
import com.tencent.state.square.api.TaskRewardItem;
import com.tencent.state.square.databinding.ZtpSquareGiftSettingDialogBinding;
import com.tencent.state.square.resource.PAGLoader;
import com.tencent.state.square.resource.PAGLoaderOption;
import com.tencent.state.view.SquareImageView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import yt4.h;
import yt4.i;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 -2\u00020\u0001:\u0001-B\u000f\u0012\u0006\u0010*\u001a\u00020)\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0016\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011J\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001eR\u0018\u0010 \u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R*\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(\u00a8\u0006."}, d2 = {"Lcom/tencent/state/square/chatland/setting/ChatLandSettingDialog;", "Landroid/app/Dialog;", "", "url", "", "setupPAGView", "setupBgImageView", "", "width", "setupIconImageView", "Landroid/widget/TextView;", "tv", "", NodeProps.COLORS, "setTextGradientColor", "Lcom/tencent/state/square/api/TaskItem;", "task", "Lcom/tencent/state/square/api/TaskRewardItem;", "taskRewardItem", "setRewardContent", "Lyt4/i;", "reward", "Lyt4/h;", "redeemReward", "setUnlockActionContent", "Lcom/tencent/state/square/databinding/ZtpSquareGiftSettingDialogBinding;", "binding", "Lcom/tencent/state/square/databinding/ZtpSquareGiftSettingDialogBinding;", "Lcom/tencent/state/view/SquareImageView;", "bgImageView", "Lcom/tencent/state/view/SquareImageView;", "iconImageView", "taskItem", "Lcom/tencent/state/square/api/TaskItem;", "Lkotlin/Function0;", "onConfirmFinished", "Lkotlin/jvm/functions/Function0;", "getOnConfirmFinished", "()Lkotlin/jvm/functions/Function0;", "setOnConfirmFinished", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ChatLandSettingDialog extends Dialog {
    private static final String PORTAL_CHANGE_DRESS_SCHEME = "mqqapi://zplan/enterAvatarScene?src_type=app&version=1.0&referer=1001&subReferer=em_zplan_state_square_entrance_task_list&sceneType=1&sceneData=%7B%22ViewType%22%3A1%2C%22SubScene%22%3A%7B%22SceneType%22%3A6%2C%22SceneParams%22%3A%7B%22active_id%22%3A%22rectab%3A2%22%7D%7D%7D";
    private static final String TAG = "ChatLandSettingDialog";
    private static final String TASK_AWARD_ICON = "https://cdn.meta.qq.com/chat_land/ztp_square_task_award.webp";
    private SquareImageView bgImageView;
    private ZtpSquareGiftSettingDialogBinding binding;
    private SquareImageView iconImageView;
    private Function0<Unit> onConfirmFinished;
    private TaskItem taskItem;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatLandSettingDialog(final Context context) {
        super(context, R.style.f243250a);
        Intrinsics.checkNotNullParameter(context, "context");
        ZtpSquareGiftSettingDialogBinding inflate = ZtpSquareGiftSettingDialogBinding.inflate(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(inflate, "ZtpSquareGiftSettingDial\u2026utInflater.from(context))");
        this.binding = inflate;
        setContentView(inflate.getMRv());
        this.binding.getMRv().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.chatland.setting.ChatLandSettingDialog.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChatLandSettingDialog.this.dismiss();
            }
        });
        this.binding.closeButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.chatland.setting.ChatLandSettingDialog.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TaskItem taskItem = ChatLandSettingDialog.this.taskItem;
                if (taskItem != null && taskItem.getItemId() == ISquareTaskServiceKt.REWARD_ITEM_ID_COIN) {
                    SquareBaseKt.getSquareRouter().routeLink(context, new EntranceLink(ChatLandSettingDialog.PORTAL_CHANGE_DRESS_SCHEME, 2));
                }
                ChatLandSettingDialog.this.dismiss();
            }
        });
        this.binding.confirmButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.chatland.setting.ChatLandSettingDialog.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Function0<Unit> onConfirmFinished = ChatLandSettingDialog.this.getOnConfirmFinished();
                if (onConfirmFinished != null) {
                    onConfirmFinished.invoke();
                }
                ChatLandSettingDialog.this.dismiss();
            }
        });
        Window window = getWindow();
        if (window != null) {
            SquareUtil squareUtil = SquareUtil.INSTANCE;
            window.setLayout(SquareUtil.getScreenWidth$default(squareUtil, 0.0f, 1, null), SquareUtil.getScreenHeight$default(squareUtil, 0.0f, 1, null));
        }
        SquareImageView squareImageView = this.binding.taskAwardIcon;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.taskAwardIcon");
        ViewExtensionsKt.setUri(squareImageView, TASK_AWARD_ICON);
        TextView textView = this.binding.taskAwardName;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.taskAwardName");
        setTextGradientColor(textView, new int[]{Color.parseColor("#DCFEB2"), Color.parseColor("#FDF1A8"), Color.parseColor("#FFF2B2")});
    }

    private final void setupBgImageView() {
        if (this.bgImageView != null) {
            return;
        }
        SquareImageView squareImageView = new SquareImageView(getContext());
        this.bgImageView = squareImageView;
        SquareUtil squareUtil = SquareUtil.INSTANCE;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(SquareUtil.getScreenWidth$default(squareUtil, 0.0f, 1, null), SquareUtil.getScreenWidth$default(squareUtil, 0.0f, 1, null));
        TextView textView = this.binding.awardDesc;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.awardDesc");
        layoutParams.addRule(2, textView.getId());
        layoutParams.addRule(14);
        Unit unit = Unit.INSTANCE;
        squareImageView.setLayoutParams(layoutParams);
        this.binding.getMRv().addView(this.bgImageView);
        final Animation anim = AnimationUtils.loadAnimation(getContext(), R.anim.f154385k7);
        Intrinsics.checkNotNullExpressionValue(anim, "anim");
        anim.setFillAfter(true);
        SquareBaseKt.getSquareThread().postOnUiDelayed(500L, new Function0<Unit>() { // from class: com.tencent.state.square.chatland.setting.ChatLandSettingDialog$setupBgImageView$2
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
                SquareImageView squareImageView2;
                squareImageView2 = ChatLandSettingDialog.this.bgImageView;
                if (squareImageView2 != null) {
                    squareImageView2.startAnimation(anim);
                }
            }
        });
    }

    private final void setupIconImageView(int width) {
        if (this.iconImageView != null) {
            return;
        }
        SquareImageView squareImageView = new SquareImageView(getContext());
        this.iconImageView = squareImageView;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(width, width);
        TextView textView = this.binding.awardDesc;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.awardDesc");
        layoutParams.addRule(2, textView.getId());
        layoutParams.addRule(14);
        layoutParams.bottomMargin = (int) ((SquareUtil.getScreenWidth$default(SquareUtil.INSTANCE, 0.0f, 1, null) - width) * 0.5d);
        Unit unit = Unit.INSTANCE;
        squareImageView.setLayoutParams(layoutParams);
        this.binding.getMRv().addView(this.iconImageView);
    }

    private final void setupPAGView(String url) {
        if (url.length() == 0) {
            return;
        }
        ICommonUtils commonUtils = SquareBase.INSTANCE.getConfig().getCommonUtils();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ISquarePagView pagView = commonUtils.getPagView(context);
        if (pagView != null) {
            View view = pagView.getView();
            SquareUtil squareUtil = SquareUtil.INSTANCE;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(SquareUtil.getScreenWidth$default(squareUtil, 0.0f, 1, null), SquareUtil.getScreenWidth$default(squareUtil, 0.0f, 1, null));
            TextView textView = this.binding.awardDesc;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.awardDesc");
            layoutParams.addRule(2, textView.getId());
            layoutParams.addRule(14);
            Unit unit = Unit.INSTANCE;
            view.setLayoutParams(layoutParams);
            this.binding.getMRv().addView(view);
            PAGLoader.INSTANCE.playPAG(url, url.hashCode() + ".pag", pagView, new PAGLoaderOption(0));
        }
    }

    public final Function0<Unit> getOnConfirmFinished() {
        return this.onConfirmFinished;
    }

    public final void setOnConfirmFinished(Function0<Unit> function0) {
        this.onConfirmFinished = function0;
    }

    public final void setRewardContent(TaskItem task, TaskRewardItem taskRewardItem) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(taskRewardItem, "taskRewardItem");
        this.taskItem = task;
        TextView textView = this.binding.closeButton;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.closeButton");
        ViewExtensionsKt.setVisibility(textView, false);
        setupBgImageView();
        setupPAGView(taskRewardItem.getSpecialUrl());
        setupIconImageView(com.tencent.state.square.common.ViewExtensionsKt.dip(getContext(), 104));
        TextView textView2 = this.binding.awardDesc;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.awardDesc");
        ViewExtensionsKt.setVisibility(textView2, true);
        SquareImageView squareImageView = this.bgImageView;
        if (squareImageView != null) {
            ViewExtensionsKt.setUri(squareImageView, taskRewardItem.getBgUrl());
        }
        long itemId = task.getItemId();
        if (itemId != ISquareTaskServiceKt.REWARD_ITEM_ID_COIN) {
            if (itemId == ISquareTaskServiceKt.REWARD_ITEM_ID_POINT) {
                SquareImageView squareImageView2 = this.iconImageView;
                if (squareImageView2 != null) {
                    ViewExtensionsKt.setUri(squareImageView2, taskRewardItem.getPointIcon());
                }
                TextView textView3 = this.binding.taskAwardName;
                Intrinsics.checkNotNullExpressionValue(textView3, "binding.taskAwardName");
                textView3.setText("\u83b7\u5f97\u79ef\u5206");
                TextView textView4 = this.binding.awardDesc;
                Intrinsics.checkNotNullExpressionValue(textView4, "binding.awardDesc");
                Unit unit = Unit.INSTANCE;
                String str = "\u79ef\u5206+" + task.getRewardItemCnt();
                Intrinsics.checkNotNullExpressionValue(str, "StringBuilder().apply(builderAction).toString()");
                textView4.setText(str);
                return;
            }
            return;
        }
        TextView textView5 = this.binding.closeButton;
        Intrinsics.checkNotNullExpressionValue(textView5, "binding.closeButton");
        ViewExtensionsKt.setVisibility(textView5, true);
        TextView textView6 = this.binding.closeButton;
        Intrinsics.checkNotNullExpressionValue(textView6, "binding.closeButton");
        textView6.setText("\u53bb\u4f7f\u7528");
        SquareImageView squareImageView3 = this.iconImageView;
        if (squareImageView3 != null) {
            ViewExtensionsKt.setUri(squareImageView3, taskRewardItem.getCoinIcon());
        }
        TextView textView7 = this.binding.taskAwardName;
        Intrinsics.checkNotNullExpressionValue(textView7, "binding.taskAwardName");
        textView7.setText("\u83b7\u5f97\u94f6\u5e01");
        TextView textView8 = this.binding.awardDesc;
        Intrinsics.checkNotNullExpressionValue(textView8, "binding.awardDesc");
        Unit unit2 = Unit.INSTANCE;
        String str2 = "\u94f6\u5e01+" + task.getRewardItemCnt();
        Intrinsics.checkNotNullExpressionValue(str2, "StringBuilder().apply(builderAction).toString()");
        textView8.setText(str2);
    }

    public final void setUnlockActionContent(i reward, h redeemReward) {
        String str;
        Intrinsics.checkNotNullParameter(reward, "reward");
        TextView textView = this.binding.taskAwardName;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.taskAwardName");
        textView.setText("\u89e3\u9501\u65b0\u52a8\u6548");
        TextView textView2 = this.binding.awardDesc;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.awardDesc");
        ViewExtensionsKt.setVisibility(textView2, false);
        Button button = this.binding.confirmButton;
        Intrinsics.checkNotNullExpressionValue(button, "binding.confirmButton");
        button.setText("\u7acb\u5373\u8bbe\u7f6e");
        if (redeemReward == null || (str = redeemReward.f451206a) == null) {
            return;
        }
        setupBgImageView();
        setupPAGView(str);
        setupIconImageView(com.tencent.state.square.common.ViewExtensionsKt.dip(getContext(), 104));
        SquareImageView squareImageView = this.bgImageView;
        if (squareImageView != null) {
            ViewExtensionsKt.setUri(squareImageView, redeemReward.f451207b);
        }
        SquareImageView squareImageView2 = this.iconImageView;
        if (squareImageView2 != null) {
            ViewExtensionsKt.setUri(squareImageView2, reward.f451213d);
        }
    }

    private final void setTextGradientColor(TextView tv5, int[] colors) {
        tv5.setTextColor(colors[0]);
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, tv5.getPaint().measureText(tv5.getText().toString()), tv5.getTextSize(), colors, (float[]) null, Shader.TileMode.CLAMP);
        TextPaint paint = tv5.getPaint();
        Intrinsics.checkNotNullExpressionValue(paint, "tv.paint");
        paint.setShader(linearGradient);
    }
}
