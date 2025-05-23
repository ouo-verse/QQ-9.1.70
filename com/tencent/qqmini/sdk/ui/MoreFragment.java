package com.tencent.qqmini.sdk.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.R;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.ui.MiniBaseFragment;
import com.tencent.qqmini.sdk.launcher.ui.MoreItem;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
@MiniKeep
/* loaded from: classes23.dex */
public class MoreFragment extends MiniBaseFragment implements View.OnClickListener, Handler.Callback {
    public static final String MINI_APP_ID = "miniAppID";
    public static final String TAG = "MoreFragment";
    private RelativeLayout actionSheet;
    private String appID = null;
    private View mAfRootView;
    private TextView mCancelText;
    private Animation mExitAnimation;
    private List<MoreItem> mMoreItemList;
    private LinearLayout mMoreItemListLayout;
    private int mScreenHeight;
    private int mStatusBarHeight;

    private void dismiss(int i3, boolean z16, Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra("miniAppID", this.appID);
            intent.putExtra(IPCConst.RESULT_MORE_ITEM_ID, i3);
            intent.putExtra(IPCConst.RESULT_SHARE_IN_MINI_PROCESS, z16);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            if (getActivity() != null) {
                getActivity().setResult(-1, intent);
                getActivity().finish();
            }
        }
    }

    private void doActionSheetUpAnimation() {
        if (this.actionSheet == null) {
            return;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setInterpolator(new DecelerateInterpolator());
        animationSet.setDuration(200L);
        animationSet.setFillAfter(true);
        this.actionSheet.startAnimation(animationSet);
    }

    private Intent getIntent() {
        if (getActivity() != null) {
            return getActivity().getIntent();
        }
        return null;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(view);
        int i3 = 0;
        if (view == this.mAfRootView) {
            z16 = false;
        } else if (view != this.mCancelText && (view instanceof MoreItemView)) {
            MoreItem moreItem = ((MoreItemView) view).getMoreItem();
            i3 = moreItem.f348090id;
            z16 = moreItem.shareInMiniProcess;
        } else {
            z16 = false;
            i3 = -1;
        }
        dismiss(i3, z16, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.mScreenHeight = getActivity().getResources().getDisplayMetrics().heightPixels;
        this.mStatusBarHeight = DisplayUtil.getStatusBarHeight(getActivity());
        View inflate = layoutInflater.inflate(R.layout.mini_sdk_more_actionsheet_layout, viewGroup, false);
        if (inflate == null) {
            getActivity().finish();
        } else {
            this.mAfRootView = inflate.findViewById(R.id.af_root);
            TextView textView = (TextView) inflate.findViewById(R.id.miniapp_dialog_cancel);
            this.mCancelText = textView;
            textView.setOnClickListener(this);
            inflate.setOnClickListener(this);
            Intent intent = getIntent();
            if (intent == null) {
                QMLog.w(TAG, "Failed to create MoreFragment, intent is null");
                if (getActivity() != null) {
                    getActivity().finish();
                }
            } else {
                if (intent.getBooleanExtra(IPCConst.KEY_ORIENTATION_LANDSCAPE, false)) {
                    getActivity().findViewById(android.R.id.content).setBackgroundResource(R.drawable.mini_sdk_more_fragment_background);
                }
                this.mMoreItemListLayout = (LinearLayout) inflate.findViewById(R.id.more_item_list_layout);
                ArrayList<MoreItem> parcelableArrayListExtra = intent.getParcelableArrayListExtra(IPCConst.KEY_MORE_ITEM_LIST);
                this.mMoreItemList = parcelableArrayListExtra;
                if (parcelableArrayListExtra == null) {
                    QMLog.e(TAG, "Failed to create MoreFragmentView. no items");
                    getActivity().finish();
                } else {
                    for (MoreItem moreItem : parcelableArrayListExtra) {
                        MoreItemView moreItemView = new MoreItemView(getActivity());
                        moreItemView.bind(moreItem);
                        moreItemView.setOnClickListener(this);
                        this.mMoreItemListLayout.addView(moreItemView);
                    }
                }
                RelativeLayout relativeLayout = (RelativeLayout) inflate;
                this.actionSheet = relativeLayout;
                relativeLayout.setVisibility(0);
                doActionSheetUpAnimation();
                AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
                return inflate;
            }
        }
        inflate = null;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        dismiss(-1, false, null);
        super.onStop();
    }
}
