package com.tencent.mobileqq.qqpermission.view;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqpermission.authorization.QQAuthorizationDialog;
import com.tencent.mobileqq.qqpermission.base.MessageNotificationInfo;
import com.tencent.mobileqq.qqpermission.util.QPLog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public class MessageNotificationAdapter extends BaseAdapter {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "MessageNotificationAdapter";
    private QQAuthorizationDialog.AuthorizationListener mAuthorizationListener;
    private Context mContext;
    private final List<MessageNotificationInfo> mMessageNotificationInfoList;
    private b mNotificationListener;
    private MessageNotificationViewHolder mViewHolder;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    static class MessageNotificationViewHolder {
        static IPatchRedirector $redirector_;
        public QUICheckBox mCheckBox;
        public TextView mContentTv;
        public ImageView mHintIv;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes17.dex */
        public class a implements View.OnClickListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Context f274339d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ MessageNotificationInfo f274340e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ QQAuthorizationDialog.AuthorizationListener f274341f;

            a(Context context, MessageNotificationInfo messageNotificationInfo, QQAuthorizationDialog.AuthorizationListener authorizationListener) {
                this.f274339d = context;
                this.f274340e = messageNotificationInfo;
                this.f274341f = authorizationListener;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, MessageNotificationViewHolder.this, context, messageNotificationInfo, authorizationListener);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    Context context = this.f274339d;
                    MessageNotificationInfo messageNotificationInfo = this.f274340e;
                    AuthorizationHintDialog buildHintDialog = AuthorizationHintDialog.buildHintDialog(context, messageNotificationInfo.hintTitle, messageNotificationInfo.hintContent);
                    buildHintDialog.setDialogHeight(AuthorizationRequestDialog.getDialogHeight());
                    QQAuthorizationDialog.AuthorizationListener authorizationListener = this.f274341f;
                    if (authorizationListener != null) {
                        authorizationListener.onSubHintDialogHide(this.f274340e, buildHintDialog);
                    }
                    try {
                        buildHintDialog.show();
                    } catch (WindowManager.BadTokenException e16) {
                        QLog.e(MessageNotificationAdapter.TAG, 1, "toShowHintDialog " + e16.getMessage());
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        MessageNotificationViewHolder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public void update(Context context, MessageNotificationInfo messageNotificationInfo, QQAuthorizationDialog.AuthorizationListener authorizationListener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, context, messageNotificationInfo, authorizationListener);
                return;
            }
            if (messageNotificationInfo.isEnable) {
                this.mCheckBox.setChecked(messageNotificationInfo.isDefaultCheck);
            } else {
                this.mCheckBox.setVisibility(8);
            }
            this.mContentTv.setText(messageNotificationInfo.content);
            if (messageNotificationInfo.isShowHintView) {
                this.mHintIv.setVisibility(0);
                this.mHintIv.setOnClickListener(new a(context, messageNotificationInfo, authorizationListener));
            } else {
                this.mHintIv.setVisibility(8);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f274343d;

        a(int i3) {
            this.f274343d = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MessageNotificationAdapter.this, i3);
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
            } else {
                MessageNotificationInfo messageNotificationInfo = (MessageNotificationInfo) MessageNotificationAdapter.this.getItem(this.f274343d);
                messageNotificationInfo.setChecked(z16);
                MessageNotificationAdapter.this.mMessageNotificationInfoList.set(this.f274343d, messageNotificationInfo);
                MessageNotificationAdapter.this.checkEmptySelection();
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static abstract class b {
        static IPatchRedirector $redirector_;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                QPLog.i(MessageNotificationAdapter.TAG, "onEmptySelection");
            }
        }

        public void b(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
                return;
            }
            QPLog.i(MessageNotificationAdapter.TAG, "onSelected. checkedCount:" + i3);
        }
    }

    public MessageNotificationAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mMessageNotificationInfoList = new ArrayList();
        }
    }

    public void checkEmptySelection() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        Iterator<MessageNotificationInfo> it = this.mMessageNotificationInfoList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (it.next().isChecked) {
                i3++;
            }
        }
        b bVar = this.mNotificationListener;
        if (bVar != null) {
            if (i3 == 0) {
                bVar.a();
            } else {
                bVar.b(i3);
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.mMessageNotificationInfoList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        return this.mMessageNotificationInfoList.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, i3)).longValue();
        }
        return i3;
    }

    public List<MessageNotificationInfo> getMessageNotificationInfoList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (List) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.mMessageNotificationInfoList;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View view2;
        View view3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            view2 = (View) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), view, viewGroup);
            view3 = view;
        } else {
            if (view != null) {
                this.mViewHolder = (MessageNotificationViewHolder) view.getTag();
            } else {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.gyy, viewGroup, false);
                MessageNotificationViewHolder messageNotificationViewHolder = new MessageNotificationViewHolder();
                this.mViewHolder = messageNotificationViewHolder;
                messageNotificationViewHolder.mCheckBox = (QUICheckBox) view.findViewById(R.id.z5g);
                this.mViewHolder.mContentTv = (TextView) view.findViewById(R.id.z5h);
                this.mViewHolder.mHintIv = (ImageView) view.findViewById(R.id.z5i);
                view.setTag(this.mViewHolder);
            }
            try {
                this.mViewHolder.update(this.mContext, this.mMessageNotificationInfoList.get(i3), this.mAuthorizationListener);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "getView exception: " + Log.getStackTraceString(e16));
            }
            this.mViewHolder.mCheckBox.setOnCheckedChangeListener(new a(i3));
            view2 = view;
            view3 = view2;
        }
        EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
        return view2;
    }

    public void setAuthorizationListener(QQAuthorizationDialog.AuthorizationListener authorizationListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) authorizationListener);
        } else {
            this.mAuthorizationListener = authorizationListener;
        }
    }

    public void setNotificationListener(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bVar);
        } else {
            this.mNotificationListener = bVar;
        }
    }

    public void updateData(Context context, List<MessageNotificationInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) context, (Object) list);
            return;
        }
        this.mContext = context;
        this.mMessageNotificationInfoList.clear();
        this.mMessageNotificationInfoList.addAll(list);
        checkEmptySelection();
    }
}
