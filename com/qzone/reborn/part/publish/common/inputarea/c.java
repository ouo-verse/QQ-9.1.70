package com.qzone.reborn.part.publish.common.inputarea;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import androidx.lifecycle.Observer;
import com.qzone.common.friend.business.model.Friend;
import com.qzone.reborn.base.k;
import com.qzone.reborn.part.publish.common.draft.QZonePublishAtFriendBean;
import com.qzone.widget.ExtendEditText;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.text.o;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.ArrayUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes37.dex */
public class c extends k {
    private static final String D = "c";

    /* renamed from: d, reason: collision with root package name */
    private final com.qzone.reborn.part.publish.common.inputarea.a f58572d;

    /* renamed from: e, reason: collision with root package name */
    private ExtendEditText f58573e;

    /* renamed from: f, reason: collision with root package name */
    private d f58574f;

    /* renamed from: h, reason: collision with root package name */
    private String f58575h;

    /* renamed from: i, reason: collision with root package name */
    private final View.OnFocusChangeListener f58576i = new a();

    /* renamed from: m, reason: collision with root package name */
    private final TextWatcher f58577m = new b();
    private final ExtendEditText.f C = new C0489c();

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements View.OnFocusChangeListener {
        a() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z16) {
            RFWLog.d(c.D, RFWLog.USR, "mFocusChangeListener, onFocusChange, v: " + view + ", hasFocus: " + z16);
            if (z16) {
                EventCollector.getInstance().onViewClicked(view);
            }
            if (c.this.f58574f == null) {
                return;
            }
            if ((view instanceof ExtendEditText) && z16) {
                c.this.f58574f.R1().postValue((ExtendEditText) view);
            } else {
                c.this.f58574f.R1().postValue(null);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.qzone.reborn.part.publish.common.inputarea.c$c, reason: collision with other inner class name */
    /* loaded from: classes37.dex */
    class C0489c implements ExtendEditText.f {
        C0489c() {
        }

        @Override // com.qzone.widget.ExtendEditText.f
        public void a(int i3) {
            c.this.f58572d.c(i3);
        }
    }

    public c(com.qzone.reborn.part.publish.common.inputarea.a aVar) {
        this.f58572d = aVar;
    }

    private void H9() {
        if (TextUtils.isEmpty(this.f58575h)) {
            return;
        }
        fo.c.o(this.f58573e, this.f58575h, null);
    }

    private void L9() {
        ((d) getViewModel(d.class)).L1().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.qzone.reborn.part.publish.common.inputarea.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                c.this.N9((QZoneInputAreaInfo) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N9(QZoneInputAreaInfo qZoneInputAreaInfo) {
        J9(qZoneInputAreaInfo);
        I9(qZoneInputAreaInfo);
    }

    public void O9(String str) {
        this.f58575h = str;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return D;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        super.handleBroadcastMessage(str, obj);
        if (TextUtils.equals(str, "update_upload_page_input_hint_text")) {
            this.f58573e.setHint(this.f58572d.a());
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        M9(view);
        L9();
        H9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        this.f58574f = (d) getViewModel(d.class);
    }

    private void I9(QZoneInputAreaInfo qZoneInputAreaInfo) {
        if (qZoneInputAreaInfo == null || this.f58574f == null || ArrayUtils.isOutOfArrayIndex(0, qZoneInputAreaInfo.atFriendBeanList)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<QZonePublishAtFriendBean> it = qZoneInputAreaInfo.atFriendBeanList.iterator();
        while (it.hasNext()) {
            QZonePublishAtFriendBean next = it.next();
            Friend friend = new Friend();
            friend.mName = next.getNickname();
            friend.mUin = next.getUin();
            arrayList.add(friend);
        }
        this.f58574f.Q1().postValue(arrayList);
    }

    private void J9(QZoneInputAreaInfo qZoneInputAreaInfo) {
        ExtendEditText extendEditText;
        if (qZoneInputAreaInfo == null || (extendEditText = this.f58573e) == null) {
            return;
        }
        extendEditText.setText(qZoneInputAreaInfo.inputContent);
    }

    private void K9(ExtendEditText extendEditText) {
        if (extendEditText == null) {
            return;
        }
        extendEditText.setEditableFactory(o.f292704d);
    }

    private void M9(View view) {
        ExtendEditText extendEditText = (ExtendEditText) view.findViewById(R.id.f68683gp);
        this.f58573e = extendEditText;
        extendEditText.setHint(this.f58572d.a());
        this.f58573e.setMaxLength(this.f58572d.b());
        this.f58573e.setLimitListener(this.C);
        this.f58573e.setOnFocusChangeListener(this.f58576i);
        this.f58573e.addTextChangedListener(this.f58577m);
        this.f58574f.T1().postValue(this.f58573e);
        K9(this.f58573e);
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            c.this.f58574f.T1().postValue(c.this.f58573e);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            c.this.f58573e.setBeforeChangeLineCount(c.this.f58573e.getLineCount());
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
