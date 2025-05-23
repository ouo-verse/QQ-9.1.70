package com.tencent.biz.qqcircle.tedgers2.bean;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.tedgers2.bean.pb.TEdgeAction$Action;
import com.tencent.biz.qqcircle.tedgers2.bean.pb.TEdgeUser$User;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tedger.outapi.beans.EdgeAction;
import com.tencent.tedger.outapi.beans.EdgeUser;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSEdgeUser extends EdgeUser {
    private static final String TAG = "TEDGEQFS_QFSEdgeUser";
    public final TEdgeUser$User mUser;

    public QFSEdgeUser(TEdgeUser$User tEdgeUser$User) {
        this.mUser = tEdgeUser$User;
    }

    public static EdgeUser getEdgeUser(byte[] bArr) {
        TEdgeUser$User tEdgeUser$User = new TEdgeUser$User();
        if (bArr != null) {
            try {
                tEdgeUser$User.mergeFrom(bArr);
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e(TAG, 1, "getEdgeUser error:" + e16);
            }
        }
        return new QFSEdgeUser(tEdgeUser$User);
    }

    @Override // com.tencent.tedger.outapi.beans.EdgeUser
    public synchronized ArrayList<EdgeAction> getActions() {
        ArrayList<EdgeAction> arrayList;
        arrayList = new ArrayList<>();
        Iterator<TEdgeAction$Action> it = this.mUser.actions.get().iterator();
        while (it.hasNext()) {
            arrayList.add(new QFSEdgeAction(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.tedger.outapi.beans.EdgeUser
    public synchronized String getUserID() {
        return this.mUser.user_id.get();
    }

    @Override // com.tencent.tedger.outapi.beans.TEdgeRSBase
    public synchronized byte[] readBussinessData() {
        return this.mUser.toByteArray();
    }

    @Override // com.tencent.tedger.outapi.beans.EdgeUser
    public void setActions(ArrayList<EdgeAction> arrayList) {
        if (arrayList != null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<EdgeAction> it = arrayList.iterator();
            while (it.hasNext()) {
                EdgeAction next = it.next();
                if (next instanceof QFSEdgeAction) {
                    arrayList2.add(((QFSEdgeAction) next).mAction);
                }
            }
            this.mUser.actions.set(arrayList2);
        }
    }

    @Override // com.tencent.tedger.outapi.beans.EdgeUser
    public synchronized String setUserID(String str) {
        QLog.d(TAG, 1, "setUserID:" + str);
        if (!TextUtils.isEmpty(str)) {
            this.mUser.user_id.set(str);
        }
        return str;
    }

    @Override // com.tencent.tedger.outapi.beans.EdgeUser
    public synchronized void updateProfile(EdgeUser edgeUser) {
        if (edgeUser instanceof QFSEdgeUser) {
            QFSEdgeUser qFSEdgeUser = (QFSEdgeUser) edgeUser;
            TEdgeUser$User tEdgeUser$User = qFSEdgeUser.mUser;
            if (tEdgeUser$User != null) {
                this.mUser.profile.set(tEdgeUser$User.profile);
                this.mUser.context.set(qFSEdgeUser.mUser.context.get());
            } else {
                QLog.e(TAG, 1, "edgeUser.mUserProfile is null");
            }
        } else {
            QLog.e(TAG, 1, "updateProfile error updateUser is :" + edgeUser);
        }
    }
}
