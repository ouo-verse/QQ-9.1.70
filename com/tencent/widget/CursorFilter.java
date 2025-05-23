package com.tencent.widget;

import android.database.Cursor;
import android.widget.Filter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
class CursorFilter extends Filter {
    static IPatchRedirector $redirector_;
    CursorFilterClient mClient;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    interface CursorFilterClient {
        void changeCursor(Cursor cursor);

        CharSequence convertToString(Cursor cursor);

        Cursor getCursor();

        Cursor runQueryOnBackgroundThread(CharSequence charSequence);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CursorFilter(CursorFilterClient cursorFilterClient) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cursorFilterClient);
        } else {
            this.mClient = cursorFilterClient;
        }
    }

    @Override // android.widget.Filter
    public CharSequence convertResultToString(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CharSequence) iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
        return this.mClient.convertToString((Cursor) obj);
    }

    @Override // android.widget.Filter
    protected Filter.FilterResults performFiltering(CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Filter.FilterResults) iPatchRedirector.redirect((short) 3, (Object) this, (Object) charSequence);
        }
        Cursor runQueryOnBackgroundThread = this.mClient.runQueryOnBackgroundThread(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (runQueryOnBackgroundThread != null) {
            filterResults.count = runQueryOnBackgroundThread.getCount();
            filterResults.values = runQueryOnBackgroundThread;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    @Override // android.widget.Filter
    protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) charSequence, (Object) filterResults);
            return;
        }
        Cursor cursor = this.mClient.getCursor();
        Object obj = filterResults.values;
        if (obj != null && obj != cursor) {
            this.mClient.changeCursor((Cursor) obj);
        }
    }
}
