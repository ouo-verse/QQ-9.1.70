package com.tencent.mobileqq.activity.contact.addcontact.groupsearch;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contact.addcontact.groupsearch.guess.GroupSearchGuessView;
import com.tencent.mobileqq.activity.contact.addcontact.groupsearch.history.GroupSearchHistoryView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class GroupSearchRecommendView extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private GroupSearchHistoryView f181169d;

    /* renamed from: e, reason: collision with root package name */
    private GroupSearchGuessView f181170e;

    /* renamed from: f, reason: collision with root package name */
    private List<com.tencent.mobileqq.activity.contact.addcontact.groupsearch.guess.b> f181171f;

    public GroupSearchRecommendView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void a() {
        if (getContext() instanceof Activity) {
            c.d((Activity) getContext(), this, "pg_search_group_middle");
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        LayoutInflater.from(getContext()).inflate(R.layout.cc9, (ViewGroup) this, true);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.vue);
        GroupSearchHistoryView groupSearchHistoryView = new GroupSearchHistoryView(getContext());
        this.f181169d = groupSearchHistoryView;
        linearLayout.addView(groupSearchHistoryView, new LinearLayout.LayoutParams(-1, -2));
        GroupSearchGuessView groupSearchGuessView = new GroupSearchGuessView(getContext());
        this.f181170e = groupSearchGuessView;
        linearLayout.addView(groupSearchGuessView, new LinearLayout.LayoutParams(-1, -2));
        List<com.tencent.mobileqq.activity.contact.addcontact.groupsearch.guess.b> list = this.f181171f;
        if (list != null) {
            setGuessData(list);
            this.f181171f = null;
        }
        a();
    }

    public void setGuessData(List<com.tencent.mobileqq.activity.contact.addcontact.groupsearch.guess.b> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) list);
            return;
        }
        GroupSearchGuessView groupSearchGuessView = this.f181170e;
        if (groupSearchGuessView != null) {
            groupSearchGuessView.setGuessData(list);
        } else {
            this.f181171f = list;
        }
    }

    public void setOnItemClickListener(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) dVar);
            return;
        }
        GroupSearchHistoryView groupSearchHistoryView = this.f181169d;
        if (groupSearchHistoryView != null) {
            groupSearchHistoryView.setOnItemClickListener(dVar);
        }
        GroupSearchGuessView groupSearchGuessView = this.f181170e;
        if (groupSearchGuessView != null) {
            groupSearchGuessView.setOnItemClickListener(dVar);
        }
    }

    public GroupSearchRecommendView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public GroupSearchRecommendView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            b();
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}
