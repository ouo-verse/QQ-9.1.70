package com.tencent.mobileqq.settings.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.friend.api.IFriendHandlerService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.settings.message.x;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;

/* loaded from: classes18.dex */
public class ChatOnlyPermissionFragment extends IphoneTitleBarFragment implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private Context C;
    private QQAppInterface D;
    private x E;
    private TextView F;
    private LinearLayout G;
    private LinearLayout H;
    private TextView I;
    private Button J;
    private final List<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> K;
    final com.tencent.mobileqq.friend.observer.a L;

    /* loaded from: classes18.dex */
    class a extends com.tencent.mobileqq.friend.observer.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatOnlyPermissionFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.friend.observer.a
        protected void onUpdateFetchByPageFriendPermission(boolean z16, List<String> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), list);
                return;
            }
            if (z16 && list != null && list.size() > 0) {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    ChatOnlyPermissionFragment.this.K.add(ChatOnlyPermissionFragment.this.th(it.next()));
                }
            }
            ChatOnlyPermissionFragment.this.sh();
        }
    }

    public ChatOnlyPermissionFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.K = new ArrayList();
            this.L = new a();
        }
    }

    private void Ah() {
        Context context = getContext();
        if (context != null && getActivity() != null) {
            Intent intent = new Intent(context, (Class<?>) ForwardFriendListActivity.class);
            intent.putStringArrayListExtra("only_chat_uins", this.E.i());
            intent.putExtra("call_by_forward", true);
            intent.putExtra("forward_type", 51);
            intent.putExtra("extra_forward_title", context.getString(R.string.f2042152a));
            intent.putExtra(ForwardRecentActivity.KEY_FORWARD_FROM_FRIEND_PERMISSION, true);
            intent.putExtra("extra_choose_friend", 5);
            intent.putExtra("only_single_selection", false);
            intent.putExtra("key_forward_finish_when_multi_select", true);
            getActivity().startActivityForResult(intent, 100);
            return;
        }
        QLog.e("ChatOnlyPermissionFragment", 1, "startAddPermissionPage | context or activity is null.");
    }

    private void Bh() {
        Context context = getContext();
        if (context != null && getActivity() != null) {
            Intent intent = new Intent(context, (Class<?>) ForwardRecentActivity.class);
            intent.putStringArrayListExtra("only_chat_uins", this.E.i());
            intent.putExtra("forward_type", 50);
            intent.putExtra(ForwardRecentActivity.KEY_FORWARD_TITLE, context.getString(R.string.f2042452d));
            intent.putExtra(ForwardRecentActivity.KEY_FORWARD_FROM_FRIEND_PERMISSION, true);
            intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 2);
            intent.putExtra("key_forward_finish_when_multi_select", true);
            getActivity().startActivityForResult(intent, 101);
            return;
        }
        QLog.e("ChatOnlyPermissionFragment", 1, "startRemovePermissionPage | context or activity is null.");
    }

    private void initDtPageReport() {
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(this.titleRoot, "pg_only_chat");
    }

    private void initUI() {
        setTitle(getBaseActivity().getString(R.string.f20448531));
        this.F = (TextView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.sdh);
        this.G = (LinearLayout) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.acy);
        this.I = (TextView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.f72913s5);
        this.H = (LinearLayout) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.f165094uv2);
        this.E = new x(this.C, this.D, (XListView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.cny), this.K);
        this.F.setOnClickListener(this);
        this.I.setOnClickListener(this);
        View findViewById = ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.ujv);
        this.J = (Button) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.ttx);
        ImageView imageView = (ImageView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.bww);
        this.J.setOnClickListener(this);
        if (QQTheme.isNowThemeIsNight() && getActivity() != null) {
            findViewById.setBackgroundColor(Color.parseColor("#1A1A1A"));
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mUseApngImage = true;
        imageView.setImageDrawable(URLDrawable.getDrawable("https://downv6.qq.com/extendfriend/research_empty_img.png", obtain));
        wh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sh() {
        if (this.E.getCount() >= 0) {
            vh();
            setTitle(String.format(getBaseActivity().getString(R.string.f20449532), Integer.valueOf(this.E.getCount())));
        } else {
            setTitle(getBaseActivity().getString(R.string.f20448531));
            zh();
        }
    }

    private void uh() {
        IFriendHandlerService iFriendHandlerService = (IFriendHandlerService) this.D.getRuntimeService(IFriendHandlerService.class, "");
        if (!NetworkUtil.isNetSupport(this.C)) {
            QQToastUtil.showQQToast(1, R.string.f171002mk);
        } else {
            iFriendHandlerService.getOnlyChatPermissionBatchByPage(0);
        }
    }

    private void vh() {
        this.H.setVisibility(8);
        this.G.setVisibility(0);
    }

    private void wh() {
        VideoReport.setElementId(this.F, "em_only_chat_add");
        TextView textView = this.F;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        VideoReport.setElementClickPolicy(textView, clickPolicy);
        VideoReport.setElementId(this.J, "em_only_chat_add");
        VideoReport.setElementClickPolicy(this.J, clickPolicy);
        VideoReport.setElementId(this.I, "em_only_chat_remove");
        VideoReport.setElementClickPolicy(this.I, clickPolicy);
    }

    private Set<String> xh(List<String> list) {
        HashSet hashSet = new HashSet();
        if (list != null && list.size() > 0) {
            hashSet.addAll(list);
        }
        return hashSet;
    }

    private void yh(View view) {
        VideoReport.reportEvent("clck", view, null);
    }

    private void zh() {
        this.H.setVisibility(0);
        this.G.setVisibility(8);
    }

    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, layoutInflater, viewGroup, bundle);
            return;
        }
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        this.C = getContext();
        QQAppInterface qQAppInterface = (QQAppInterface) getQBaseActivity().getAppRuntime();
        this.D = qQAppInterface;
        qQAppInterface.addObserver(this.L);
        initUI();
        initDtPageReport();
        uh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return R.layout.h3q;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (i16 == -1 && intent != null) {
            if (i3 == 101) {
                Set<String> xh5 = xh(intent.getStringArrayListExtra("only_chat_remove_uins"));
                Iterator<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> it = this.E.h().iterator();
                while (it.hasNext()) {
                    if (xh5.contains(it.next().x())) {
                        it.remove();
                    }
                }
                this.E.notifyDataSetChanged();
                sh();
                return;
            }
            if (i3 == 100) {
                ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("only_chat_add_uins");
                ArrayList arrayList = new ArrayList();
                if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
                    Iterator<String> it5 = stringArrayListExtra.iterator();
                    while (it5.hasNext()) {
                        arrayList.add(th(it5.next()));
                    }
                }
                this.E.h().addAll(arrayList);
                this.E.notifyDataSetChanged();
                sh();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
        } else {
            yh(view);
            int id5 = view.getId();
            if (id5 != R.id.ttx && id5 != R.id.sdh) {
                if (id5 == R.id.f72913s5) {
                    Bh();
                }
            } else {
                Ah();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onDestroy();
        this.D.removeObserver(this.L);
        this.E.destroy();
    }

    public com.tencent.qqnt.ntrelation.friendsinfo.bean.d th(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.qqnt.ntrelation.friendsinfo.bean.d) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        return ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "ChatOnlyPermissionFragment");
    }
}
