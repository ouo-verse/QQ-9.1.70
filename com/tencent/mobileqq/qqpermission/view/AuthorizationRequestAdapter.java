package com.tencent.mobileqq.qqpermission.view;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqpermission.base.AuthorizationMessage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public class AuthorizationRequestAdapter extends BaseAdapter {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "AuthorizationRequestAdapter";
    private final List<AuthorizationMessage> mAuthorizationMessageList;
    private int mCheckedPosition;
    private AuthorizationRequestViewHolder mViewHolder;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    static class AuthorizationRequestViewHolder {
        static IPatchRedirector $redirector_;
        public ImageView mCheckIv;
        public TextView mListContentTv;
        public TextView mListSupplementTv;

        AuthorizationRequestViewHolder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public void update(AuthorizationMessage authorizationMessage) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) authorizationMessage);
                return;
            }
            this.mListContentTv.setText(authorizationMessage.content);
            if (authorizationMessage.supplement != null) {
                this.mListSupplementTv.setVisibility(0);
                this.mListSupplementTv.setText(authorizationMessage.supplement);
            } else {
                this.mListSupplementTv.setVisibility(8);
            }
        }
    }

    public AuthorizationRequestAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mAuthorizationMessageList = new ArrayList();
            this.mCheckedPosition = 0;
        }
    }

    public int getCheckedPosition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.mCheckedPosition;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.mAuthorizationMessageList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        return this.mAuthorizationMessageList.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, i3)).longValue();
        }
        return i3;
    }

    public List<AuthorizationMessage> getResponsesInfoList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (List) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.mAuthorizationMessageList;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View view2;
        View view3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            view2 = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
            view3 = view;
        } else {
            if (view != null) {
                this.mViewHolder = (AuthorizationRequestViewHolder) view.getTag();
            } else {
                view = LayoutInflater.from(viewGroup.getContext().getApplicationContext()).inflate(R.layout.f168789gw3, viewGroup, false);
                AuthorizationRequestViewHolder authorizationRequestViewHolder = new AuthorizationRequestViewHolder();
                this.mViewHolder = authorizationRequestViewHolder;
                authorizationRequestViewHolder.mListContentTv = (TextView) view.findViewById(R.id.syl);
                this.mViewHolder.mListSupplementTv = (TextView) view.findViewById(R.id.sym);
                this.mViewHolder.mCheckIv = (ImageView) view.findViewById(R.id.syd);
                view.setTag(this.mViewHolder);
            }
            AuthorizationMessage authorizationMessage = this.mAuthorizationMessageList.get(i3);
            try {
                this.mViewHolder.update(authorizationMessage);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "getView exception: " + Log.getStackTraceString(e16));
            }
            if (i3 == this.mCheckedPosition) {
                authorizationMessage.isChecked = true;
                this.mViewHolder.mCheckIv.setVisibility(0);
            } else {
                authorizationMessage.isChecked = false;
                this.mViewHolder.mCheckIv.setVisibility(8);
            }
            view2 = view;
            view3 = view2;
        }
        EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
        return view2;
    }

    public void setCheckedPosition(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.mCheckedPosition = i3;
        }
    }

    public void updateData(List<AuthorizationMessage> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) list);
        } else {
            this.mAuthorizationMessageList.clear();
            this.mAuthorizationMessageList.addAll(list);
        }
    }
}
