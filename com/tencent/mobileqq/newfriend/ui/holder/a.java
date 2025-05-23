package com.tencent.mobileqq.newfriend.ui.holder;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import com.tencent.mobileqq.phonecontact.data.PhoneContactAdd;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.widget.SwipRightMenuBuilder;
import tencent.mobileim.structmsg.structmsg$StructMsg;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a extends SwipRightMenuBuilder.SwipItemBaseHolder {
    static IPatchRedirector $redirector_;
    public TextView C;
    public long D;
    public structmsg$StructMsg E;
    public long F;
    public String G;
    public int H;
    public PhoneContactAdd I;
    public QIMNotifyAddFriend J;
    public ImageView K;

    /* renamed from: d, reason: collision with root package name */
    public ImageView f254166d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f254167e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f254168f;

    /* renamed from: h, reason: collision with root package name */
    public TextView f254169h;

    /* renamed from: i, reason: collision with root package name */
    public TextView f254170i;

    /* renamed from: m, reason: collision with root package name */
    public Button f254171m;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
