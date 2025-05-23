package com.tencent.relation.common.widget.squaredIndicator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mutualmark.model.MutualMarkModel;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment;
import com.tencent.relation.common.utils.j;
import java.util.ArrayList;
import java.util.List;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SquaredFragment extends ReportAndroidXFragment {
    static IPatchRedirector $redirector_;
    private RecyclerView C;
    private List<MutualMarkModel> D;
    private int E;
    private e F;
    private WeakReference<View.OnClickListener> G;
    private boolean H;

    public SquaredFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.D = new ArrayList();
        this.E = 0;
        this.H = false;
    }

    public static SquaredFragment qh(ArrayList<MutualMarkModel> arrayList, int i3) {
        SquaredFragment squaredFragment = new SquaredFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("arg_param1_list", arrayList);
        bundle.putInt("arg_param1_to_light_up_count", i3);
        squaredFragment.setArguments(bundle);
        return squaredFragment;
    }

    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        e eVar = this.F;
        if (eVar != null) {
            return eVar.onBackEvent();
        }
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.D = arguments.getParcelableArrayList("arg_param1_list");
            this.E = arguments.getInt("arg_param1_to_light_up_count");
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            inflate = (View) iPatchRedirector.redirect((short) 2, this, layoutInflater, viewGroup, bundle);
        } else {
            inflate = layoutInflater.inflate(R.layout.fg9, viewGroup, false);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        WeakReference<View.OnClickListener> weakReference;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) bundle);
            return;
        }
        super.onViewCreated(view, bundle);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.f7885487);
        this.C = recyclerView;
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), 5));
        int a16 = j.a(9.0f);
        this.C.addItemDecoration(new h(getContext(), 5, a16, a16));
        this.F = new e(getContext(), this.D, this.E);
        this.C.setMotionEventSplittingEnabled(false);
        if (!this.H && (weakReference = this.G) != null && weakReference.get() != null) {
            sh(this.G);
        }
        this.C.setAdapter(this.F);
    }

    public void ph(int i3, WeakReference<a> weakReference) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3, (Object) weakReference);
            return;
        }
        a aVar = weakReference.get();
        if (aVar == null) {
            return;
        }
        RecyclerView recyclerView = this.C;
        if (recyclerView == null) {
            aVar.a(null);
        } else {
            aVar.a(recyclerView.getChildAt(i3));
        }
    }

    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.G = null;
        RecyclerView recyclerView = this.C;
        if (recyclerView != null) {
            recyclerView.setOnTouchListener(null);
        }
        this.C = null;
    }

    public void rh(List<MutualMarkModel> list, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) list, i3);
            return;
        }
        e eVar = this.F;
        if (eVar != null && list != null) {
            eVar.q0(list, i3);
        }
    }

    public void sh(WeakReference<View.OnClickListener> weakReference) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) weakReference);
            return;
        }
        RecyclerView recyclerView = this.C;
        if (recyclerView != null) {
            b.a(recyclerView, weakReference);
            this.H = true;
        }
        this.G = weakReference;
        e eVar = this.F;
        if (eVar != null) {
            eVar.r0(weakReference);
        }
    }
}
