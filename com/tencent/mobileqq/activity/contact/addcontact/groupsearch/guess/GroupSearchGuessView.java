package com.tencent.mobileqq.activity.contact.addcontact.groupsearch.guess;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.search.prompt.history.j;
import com.tencent.biz.richframework.part.block.base.SafeGridLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contact.addcontact.groupsearch.c;
import com.tencent.mobileqq.activity.contact.addcontact.groupsearch.d;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.UnifySearchHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class GroupSearchGuessView extends FrameLayout implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private RecyclerView f181179d;

    /* renamed from: e, reason: collision with root package name */
    private View f181180e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f181181f;

    /* renamed from: h, reason: collision with root package name */
    private a f181182h;

    /* renamed from: i, reason: collision with root package name */
    private RotateAnimation f181183i;

    /* renamed from: m, reason: collision with root package name */
    private UnifySearchHandler f181184m;

    public GroupSearchGuessView(@NonNull Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void a(int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("current_number_guessing_searches", Integer.valueOf(i3));
        View view = this.f181180e;
        c.c(view, "em_bas_change_the_buttons", hashMap, view.hashCode());
    }

    private void b(@NonNull Context context) {
        LayoutInflater.from(context).inflate(R.layout.h6h, (ViewGroup) this, true);
        this.f181179d = (RecyclerView) findViewById(R.id.f80954cv);
        this.f181180e = findViewById(R.id.f81124db);
        this.f181181f = (ImageView) findViewById(R.id.f81134dc);
        this.f181180e.setOnClickListener(this);
        this.f181182h = new a();
        this.f181179d.setLayoutManager(new SafeGridLayoutManager(getContext(), 2));
        this.f181179d.setAdapter(this.f181182h);
        c();
        d();
        setVisibility(8);
    }

    private void c() {
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.f181183i = rotateAnimation;
        rotateAnimation.setDuration(400L);
        this.f181183i.setInterpolator(new lc0.a(0.5f, 0.0f, 0.5f, 1.0f));
    }

    private void d() {
        if (!(getContext() instanceof BaseActivity)) {
            return;
        }
        this.f181184m = (UnifySearchHandler) ((BaseActivity) getContext()).getAppInterface().getBusinessHandler(BusinessHandlerFactory.UNIFY_SEARCH_UNITE_HANDLER);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else if (view == this.f181180e) {
            this.f181181f.startAnimation(this.f181183i);
            UnifySearchHandler unifySearchHandler = this.f181184m;
            if (unifySearchHandler != null) {
                unifySearchHandler.E2(true);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setGuessData(List<b> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) list);
            return;
        }
        if (list != null && !list.isEmpty()) {
            if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
                QLog.d("GroupSearchGuessView", 1, "[setGuessData] studyModeSwitch on");
                setVisibility(8);
                return;
            }
            QLog.d("GroupSearchGuessView", 1, "[setGuessData] size:" + list.size());
            setVisibility(0);
            a aVar = this.f181182h;
            if (aVar != null) {
                aVar.setDatas(list);
            }
            a(list.size());
            post(new j());
            return;
        }
        QLog.e("GroupSearchGuessView", 1, "[setGuessData] isEmpty");
        setVisibility(8);
    }

    public void setOnItemClickListener(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) dVar);
            return;
        }
        a aVar = this.f181182h;
        if (aVar != null) {
            aVar.j0(dVar);
        }
    }

    public GroupSearchGuessView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public GroupSearchGuessView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            b(context);
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}
