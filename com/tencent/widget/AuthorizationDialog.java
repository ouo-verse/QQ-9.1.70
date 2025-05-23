package com.tencent.widget;

import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import com.tencent.gdtad.util.GdtUserInfoAuthorizationHelper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AuthorizationItem;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AuthorizationDialog extends ActionSheet implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private GdtUserInfoAuthorizationHelper.UserInfoCallback callback;
    private final GdtUserInfoAuthorizationHelper.UserInfoEntity entity;
    private final List<AuthorizationItem.ItemType> itemTypes;

    public AuthorizationDialog(Activity activity, GdtUserInfoAuthorizationHelper.UserInfoEntity userInfoEntity, GdtUserInfoAuthorizationHelper.UserInfoCallback userInfoCallback, List<AuthorizationItem.ItemType> list) {
        super(activity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, activity, userInfoEntity, userInfoCallback, list);
            return;
        }
        this.itemTypes = list;
        this.entity = userInfoEntity;
        this.callback = userInfoCallback;
        initView();
    }

    private AuthorizationItem createItem(AuthorizationItem.ItemType itemType, int i3, String str) {
        return new AuthorizationItem(getContext(), str, itemType, i3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0043, code lost:
    
        if (r4 == 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0046, code lost:
    
        r5 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004e, code lost:
    
        if (r4 < (r2 - 1)) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void initView() {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.c7w, (ViewGroup) null);
        LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(R.id.dpq);
        List<AuthorizationItem.ItemType> list = this.itemTypes;
        if (list != null && list.size() > 0) {
            int size = this.itemTypes.size();
            int i3 = 0;
            while (i3 < size) {
                if (this.itemTypes.get(i3) != AuthorizationItem.ITEM_TYPE_NONE) {
                    int i16 = 1;
                    if (size == 1) {
                        i16 = 3;
                    } else if (size != 2) {
                        if (i3 != 0) {
                        }
                        i16 = 0;
                    }
                    linearLayout2.addView(createItem(this.itemTypes.get(i3), i16, this.entity.getInfoByKey(this.itemTypes.get(i3).key)));
                }
                i3++;
            }
        }
        addView(linearLayout);
        linearLayout.findViewById(R.id.afr).setOnClickListener(this);
        linearLayout.findViewById(R.id.agd).setOnClickListener(this);
        linearLayout.findViewById(R.id.lnx).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.lnx) {
                if (QLog.isColorLevel()) {
                    QLog.d("ActionSheet", 2, "onClick to show authorize description");
                }
                AuthorizationDescriptionDialog authorizationDescriptionDialog = new AuthorizationDescriptionDialog(getContext());
                Window window = authorizationDescriptionDialog.getWindow();
                if (window != null) {
                    window.setWindowAnimations(R.style.f173293c);
                }
                authorizationDescriptionDialog.show();
            } else if (id5 == R.id.afr) {
                if (QLog.isColorLevel()) {
                    QLog.d("ActionSheet", 2, "onClick to cancel authorize dialog");
                }
                GdtUserInfoAuthorizationHelper.UserInfoCallback userInfoCallback = this.callback;
                if (userInfoCallback != null) {
                    GdtUserInfoAuthorizationHelper.UserInfoEntity userInfoEntity = this.entity;
                    userInfoEntity.errCode = 2;
                    userInfoCallback.onUserInfo(userInfoEntity);
                }
                dismiss();
            } else if (id5 == R.id.agd) {
                if (QLog.isColorLevel()) {
                    QLog.d("ActionSheet", 2, "onClick to confirm authorize user info");
                }
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext().getApplicationContext());
                for (int i3 = 0; i3 < this.itemTypes.size(); i3++) {
                    AuthorizationItem.ItemType itemType = this.itemTypes.get(i3);
                    if (!TextUtils.isEmpty(this.entity.getInfoByKey(itemType.key))) {
                        defaultSharedPreferences.edit().putBoolean(itemType.key, true).apply();
                        if (QLog.isColorLevel()) {
                            QLog.d("ActionSheet", 2, "record " + itemType.key + " authorize");
                        }
                    }
                }
                GdtUserInfoAuthorizationHelper.UserInfoCallback userInfoCallback2 = this.callback;
                if (userInfoCallback2 != null) {
                    GdtUserInfoAuthorizationHelper.UserInfoEntity userInfoEntity2 = this.entity;
                    userInfoEntity2.errCode = 0;
                    userInfoCallback2.onUserInfo(userInfoEntity2);
                }
                dismiss();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
