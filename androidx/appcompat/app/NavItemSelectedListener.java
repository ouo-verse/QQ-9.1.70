package androidx.appcompat.app;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.ActionBar;

/* compiled from: P */
/* loaded from: classes.dex */
class NavItemSelectedListener implements AdapterView.OnItemSelectedListener {
    private final ActionBar.OnNavigationListener mListener;

    public NavItemSelectedListener(ActionBar.OnNavigationListener onNavigationListener) {
        this.mListener = onNavigationListener;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i3, long j3) {
        ActionBar.OnNavigationListener onNavigationListener = this.mListener;
        if (onNavigationListener != null) {
            onNavigationListener.onNavigationItemSelected(i3, j3);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
