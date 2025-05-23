package com.tencent.mobileqq.troop.activity.editinfo;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;

/* compiled from: P */
/* loaded from: classes19.dex */
public interface b {
    View.OnClickListener a();

    void b(int i3);

    void c(ViewGroup viewGroup, EditText editText, ViewGroup viewGroup2);

    int d();

    EmoticonCallback e();

    Intent f(Intent intent);

    void g(a aVar);

    TextView.OnEditorActionListener h();

    com.tencent.mobileqq.widget.navbar.a i();

    void onActivityResult(int i3, int i16, Intent intent);

    void onTextChanged();
}
