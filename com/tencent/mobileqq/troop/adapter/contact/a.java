package com.tencent.mobileqq.troop.adapter.contact;

import android.widget.CheckBox;
import android.widget.ProgressBar;
import com.tencent.mobileqq.activity.contacts.friend.SimpleTextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.widget.SingleLineTextView;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f293797a;

    /* renamed from: b, reason: collision with root package name */
    public CheckBox f293798b;

    /* renamed from: c, reason: collision with root package name */
    public ProgressBar f293799c;

    /* renamed from: d, reason: collision with root package name */
    public SingleLineTextView f293800d;

    /* renamed from: e, reason: collision with root package name */
    public SingleLineTextView f293801e;

    /* renamed from: f, reason: collision with root package name */
    public SimpleTextView f293802f;

    /* renamed from: g, reason: collision with root package name */
    public StringBuilder f293803g;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
