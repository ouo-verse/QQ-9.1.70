package com.qzone.reborn.part.publish.common.inputarea;

import android.text.TextUtils;
import android.widget.EditText;
import androidx.lifecycle.MutableLiveData;
import com.qzone.common.activities.base.QZoneFontTabView;
import com.qzone.common.activities.base.aj;
import com.qzone.common.friend.business.model.Friend;
import com.qzone.reborn.part.publish.common.draft.QZonePublishAtFriendBean;
import com.qzone.util.l;
import com.qzone.widget.ExtendEditText;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ArrayUtils;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class d extends ql.a<QZoneInputAreaInfo> {
    public static final String F = "d";
    private QZoneFontTabView E;

    /* renamed from: m, reason: collision with root package name */
    private final MutableLiveData<ExtendEditText> f58581m = new MutableLiveData<>();
    private final MutableLiveData<ExtendEditText> C = new MutableLiveData<>(null);
    private final MutableLiveData<List<Friend>> D = new MutableLiveData<>(null);

    private String W1(EditText editText) {
        QQTextBuilder qQTextBuilder;
        if (editText == null) {
            return "";
        }
        if ((editText.getText() instanceof QQTextBuilder) && (qQTextBuilder = (QQTextBuilder) editText.getText()) != null) {
            QLog.i(F, 2, " get plain text is " + qQTextBuilder.toPlainText());
            return qQTextBuilder.toPlainText();
        }
        if (editText.getEditableText() == null) {
            return "";
        }
        QLog.i(F, 2, " get plain text is " + editText.getEditableText().toString());
        return editText.getEditableText().toString();
    }

    private void a2(QZoneInputAreaInfo qZoneInputAreaInfo) {
        ArrayList<QZonePublishAtFriendBean> arrayList = new ArrayList<>();
        if (this.D.getValue() != null && !ArrayUtils.isOutOfArrayIndex(0, this.D.getValue())) {
            for (Friend friend : this.D.getValue()) {
                QZonePublishAtFriendBean qZonePublishAtFriendBean = new QZonePublishAtFriendBean();
                qZonePublishAtFriendBean.setUin(friend.mUin);
                qZonePublishAtFriendBean.setNickname(friend.mName);
                arrayList.add(qZonePublishAtFriendBean);
            }
        }
        qZoneInputAreaInfo.atFriendBeanList = arrayList;
    }

    private void b2(QZoneInputAreaInfo qZoneInputAreaInfo) {
        if (this.f58581m.getValue() != null && this.f58581m.getValue().getText() != null && !TextUtils.isEmpty(this.f58581m.getValue().getText().toString())) {
            qZoneInputAreaInfo.inputContent = this.f58581m.getValue().getText().toString();
        } else {
            qZoneInputAreaInfo.inputContent = "";
        }
    }

    @Override // ql.a
    public boolean M1() {
        return U1().length() > 0;
    }

    public QZoneInputAreaInfo O1() {
        QZoneInputAreaInfo qZoneInputAreaInfo = new QZoneInputAreaInfo();
        b2(qZoneInputAreaInfo);
        a2(qZoneInputAreaInfo);
        return qZoneInputAreaInfo;
    }

    public QZoneInputAreaInfo P1() {
        QZoneInputAreaInfo qZoneInputAreaInfo = new QZoneInputAreaInfo();
        qZoneInputAreaInfo.inputContent = U1();
        return qZoneInputAreaInfo;
    }

    public MutableLiveData<List<Friend>> Q1() {
        return this.D;
    }

    public MutableLiveData<ExtendEditText> R1() {
        return this.C;
    }

    public QZoneFontTabView S1() {
        return this.E;
    }

    public MutableLiveData<ExtendEditText> T1() {
        return this.f58581m;
    }

    public String U1() {
        String W1 = W1(this.f58581m.getValue());
        if (TextUtils.isEmpty(W1)) {
            return W1;
        }
        String b16 = aj.b(W1, this.D.getValue(), false);
        RFWLog.i(F, RFWLog.CLR, "string after replace is " + b16);
        return QzoneEmotionUtils.splash2Emo(b16.replaceAll(l.a(R.string.f172111ng0), l.a(R.string.f172113ng2)).replaceAll(l.a(R.string.nfz), "/MM").replaceAll(BaseApplicationImpl.sApplication.getResources().getString(R.string.f2192465w), "/chigua"));
    }

    public boolean X1() {
        return M1();
    }

    public void Z1(QZoneFontTabView qZoneFontTabView) {
        this.E = qZoneFontTabView;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return F;
    }
}
