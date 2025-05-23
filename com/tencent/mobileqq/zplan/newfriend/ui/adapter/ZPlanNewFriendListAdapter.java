package com.tencent.mobileqq.zplan.newfriend.ui.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.newfriend.msg.c;
import com.tencent.mobileqq.newfriend.msg.controller.FriendSystemMsgController;
import com.tencent.mobileqq.newfriend.msg.i;
import com.tencent.mobileqq.newfriend.ui.adapter.NewFriendMoreSysMsgAdapter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SwipListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.mobileim.structmsg.structmsg$StructMsg;
import tencent.mobileim.structmsg.structmsg$SystemMsg;

/* loaded from: classes21.dex */
public class ZPlanNewFriendListAdapter extends NewFriendMoreSysMsgAdapter {

    /* renamed from: b0, reason: collision with root package name */
    private com.tencent.mobileqq.newfriend.observer.a f334893b0;

    public ZPlanNewFriendListAdapter(Activity activity, AppInterface appInterface, SwipListView swipListView, View view, View view2, FlingHandler flingHandler, int i3) {
        super(activity, appInterface, swipListView, view, view2, flingHandler, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<ChatMessage> Q() {
        AppInterface appInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface == null) {
            return null;
        }
        return ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).getAIOList(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, FriendSystemMsgController.e().f(appInterface));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean R(structmsg$SystemMsg structmsg_systemmsg) {
        if (structmsg_systemmsg == null || structmsg_systemmsg.sub_type.get() != 1) {
            return false;
        }
        if (structmsg_systemmsg.src_id.get() != 3177 && structmsg_systemmsg.src_id.get() != 3178 && structmsg_systemmsg.src_id.get() != 2177 && structmsg_systemmsg.src_id.get() != 2178) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.newfriend.ui.adapter.NewFriendMoreSysMsgAdapter
    protected void e() {
        this.f334893b0 = new a();
        AppInterface appInterface = this.C;
        if (appInterface != null) {
            appInterface.addObserver(this.S);
            this.C.addObserver(this.V);
            this.C.addObserver(this.f334893b0);
        }
    }

    @Override // com.tencent.mobileqq.newfriend.ui.adapter.NewFriendMoreSysMsgAdapter
    public void onDestroy() {
        AppInterface appInterface = this.C;
        if (appInterface != null) {
            appInterface.removeObserver(this.S);
            this.C.removeObserver(this.V);
            this.C.removeObserver(this.f334893b0);
        }
        IFaceDecoder iFaceDecoder = this.E;
        if (iFaceDecoder != null) {
            iFaceDecoder.setDecodeTaskCompletionListener(null);
            this.E.destory();
        }
    }

    @Override // com.tencent.mobileqq.newfriend.ui.adapter.NewFriendMoreSysMsgAdapter
    protected Bundle p(structmsg$StructMsg structmsg_structmsg) {
        Bundle bundle = new Bundle();
        if (structmsg_structmsg == null) {
            return bundle;
        }
        bundle.putString("base_uin", String.valueOf(structmsg_structmsg.req_uin.get()));
        String str = structmsg_structmsg.f436065msg.req_uin_nick.get();
        if (TextUtils.isEmpty(str)) {
            str = String.valueOf(structmsg_structmsg.req_uin.get());
        }
        bundle.putString("base_nick", str);
        bundle.putInt("verfy_type", structmsg_structmsg.f436065msg.sub_type.get());
        bundle.putString("verfy_msg", structmsg_structmsg.f436065msg.msg_additional.get());
        bundle.putBoolean("param_go_back_after_setting_done", true);
        return bundle;
    }

    @Override // com.tencent.mobileqq.newfriend.ui.adapter.NewFriendMoreSysMsgAdapter
    protected void r(com.tencent.mobileqq.newfriend.ui.holder.a aVar) {
        if (QLog.isColorLevel()) {
            QLog.d("ZPlanNewFriendListAdapter", 2, "handleBuddySystemMsg! start " + aVar.D);
        }
        if (aVar.E.f436065msg.sub_type.get() == 1) {
            String str = aVar.E.f436065msg.req_uin_nick.get();
            if (TextUtils.isEmpty(str)) {
                str = String.valueOf(aVar.E.req_uin.get());
            }
            Intent intent = new Intent();
            intent.putExtra("infoid", aVar.D);
            intent.putExtra("infouin", String.valueOf(aVar.E.req_uin.get()));
            intent.putExtra("infonick", str);
            intent.putExtra("infotime", aVar.E.msg_time.get());
            intent.putExtra(QQHealthReportApiImpl.MSG_TYPE_KEY, aVar.E.f436065msg.sub_type.get());
            intent.putExtra("strNickName", str);
            intent.putExtra("verify_msg", aVar.E.f436065msg.msg_additional.get());
            intent.putExtra("msg_source", aVar.E.f436065msg.msg_source.get());
            intent.putExtra("msg_troopuin", aVar.E.f436065msg.group_code.get());
            intent.putExtra(AppConstants.Key.SYSTEM_MESSAGE_SUMMARY, aVar.E.f436065msg.msg_decided.get());
            intent.putExtra("info_dealwith_msg", aVar.E.f436065msg.msg_detail.get());
            intent.putExtra("msg_title", aVar.E.f436065msg.msg_title.get());
            intent.putExtra("msg_source_id", aVar.E.f436065msg.src_id.get());
            intent.putExtra("param_go_back_after_setting_done", true);
            intent.putExtra("verify_type", 1);
            z(aVar.E.get(), aVar.F);
            ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).startAddRequestPage(this.f254069m, intent);
        }
    }

    @Override // com.tencent.mobileqq.newfriend.ui.adapter.NewFriendMoreSysMsgAdapter
    protected void x(final boolean z16) {
        ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.zplan.newfriend.ui.adapter.ZPlanNewFriendListAdapter.2
            @Override // java.lang.Runnable
            public void run() {
                structmsg$SystemMsg structmsg_systemmsg;
                final ArrayList arrayList = new ArrayList();
                List Q = ZPlanNewFriendListAdapter.this.Q();
                if (Q != null && Q.size() > 0) {
                    for (int size = Q.size() - 1; size >= 0; size--) {
                        MessageRecord messageRecord = (MessageRecord) Q.get(size);
                        if (messageRecord instanceof MessageForSystemMsg) {
                            MessageForSystemMsg messageForSystemMsg = (MessageForSystemMsg) messageRecord;
                            if (messageForSystemMsg.structMsg == null) {
                                messageForSystemMsg.parse();
                            }
                            structmsg$StructMsg structmsg_structmsg = messageForSystemMsg.structMsg;
                            if (structmsg_structmsg != null && (structmsg_systemmsg = structmsg_structmsg.f436065msg) != null && ZPlanNewFriendListAdapter.this.R(structmsg_systemmsg)) {
                                arrayList.add(new c(messageForSystemMsg));
                            }
                        }
                    }
                }
                Collections.sort(arrayList, ((NewFriendMoreSysMsgAdapter) ZPlanNewFriendListAdapter.this).R);
                ((NewFriendMoreSysMsgAdapter) ZPlanNewFriendListAdapter.this).C.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.zplan.newfriend.ui.adapter.ZPlanNewFriendListAdapter.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ((NewFriendMoreSysMsgAdapter) ZPlanNewFriendListAdapter.this).J = arrayList;
                        ZPlanNewFriendListAdapter.this.notifyDataSetChanged();
                        if (ZPlanNewFriendListAdapter.this.getCount() > 0) {
                            ZPlanNewFriendListAdapter.this.f254065e.setVisibility(0);
                            ((NewFriendMoreSysMsgAdapter) ZPlanNewFriendListAdapter.this).f254064d.setVisibility(8);
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            if (z16 && ((NewFriendMoreSysMsgAdapter) ZPlanNewFriendListAdapter.this).L < ZPlanNewFriendListAdapter.this.getCount()) {
                                ZPlanNewFriendListAdapter zPlanNewFriendListAdapter = ZPlanNewFriendListAdapter.this;
                                zPlanNewFriendListAdapter.f254065e.setSelection(((NewFriendMoreSysMsgAdapter) zPlanNewFriendListAdapter).L);
                                return;
                            }
                            return;
                        }
                        ((NewFriendMoreSysMsgAdapter) ZPlanNewFriendListAdapter.this).f254064d.setVisibility(0);
                        ZPlanNewFriendListAdapter.this.f254065e.setVisibility(8);
                    }
                });
            }
        }, null, true);
    }

    /* loaded from: classes21.dex */
    class a extends com.tencent.mobileqq.newfriend.observer.a {
        a() {
        }

        @Override // com.tencent.mobileqq.newfriend.observer.a
        protected void b(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            ArrayList arrayList = (ArrayList) ((NewFriendMoreSysMsgAdapter) ZPlanNewFriendListAdapter.this).J.clone();
            if (!arrayList.isEmpty()) {
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    i iVar = (i) it.next();
                    if ((iVar instanceof c) && str.equals(((c) iVar).f254022d.senderuin)) {
                        it.remove();
                        break;
                    }
                }
                ((NewFriendMoreSysMsgAdapter) ZPlanNewFriendListAdapter.this).J = arrayList;
                ZPlanNewFriendListAdapter.this.notifyDataSetChanged();
            }
        }

        @Override // com.tencent.mobileqq.newfriend.observer.a
        protected void i(boolean z16, String str, String str2, byte b16) {
            if (z16) {
                ZPlanNewFriendListAdapter.this.notifyDataSetChanged();
            }
        }

        @Override // com.tencent.mobileqq.newfriend.observer.a
        protected void l(String str, boolean z16) {
            int i3;
            if (z16) {
                ZPlanNewFriendListAdapter.this.notifyDataSetChanged();
            }
            Activity activity = ((NewFriendMoreSysMsgAdapter) ZPlanNewFriendListAdapter.this).f254069m;
            if (z16) {
                i3 = R.string.f170782lz;
            } else {
                i3 = R.string.f170772ly;
            }
            QQToast.makeText(activity, i3, 0).show();
        }

        @Override // com.tencent.mobileqq.newfriend.observer.a
        public void c(String str) {
        }

        @Override // com.tencent.mobileqq.newfriend.observer.a
        public void j(boolean z16, int i3, int i16) {
        }
    }
}
