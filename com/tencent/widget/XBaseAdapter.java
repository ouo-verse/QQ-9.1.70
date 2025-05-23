package com.tencent.widget;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class XBaseAdapter extends BaseAdapter implements XListAdapter {
    static IPatchRedirector $redirector_;
    private final ListDataSetObservable mDataSetObservable;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface ListDataSetListener {
        void onRowDeleted(int i3, int i16);

        void onRowDeleted(int... iArr);

        void onRowInserted(int i3, int i16);

        void onRowUpdated(int i3, int i16);
    }

    public XBaseAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mDataSetObservable = new ListDataSetObservable();
        }
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.mDataSetObservable.notifyChanged();
        }
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.mDataSetObservable.notifyInvalidated();
        }
    }

    public void notifyRowDeleted(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.mDataSetObservable.notifyRowDeleted(i3, i16);
        }
    }

    public void notifyRowInserted(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.mDataSetObservable.notifyRowInserted(i3, i16);
        }
    }

    public void notifyRowUpdated(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.mDataSetObservable.notifyRowUpdated(i3, i16);
        }
    }

    public void notifyRowsDeleted(int... iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) iArr);
        } else {
            this.mDataSetObservable.notifyRowDeleted(iArr);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dataSetObserver);
        } else {
            this.mDataSetObservable.registerObserver(dataSetObserver);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) dataSetObserver);
        } else {
            this.mDataSetObservable.unregisterObserver(dataSetObserver);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    class ListDataSetObservable extends DataSetObservable {
        static IPatchRedirector $redirector_;

        ListDataSetObservable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) XBaseAdapter.this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void notifyRowDeleted(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            synchronized (((DataSetObservable) this).mObservers) {
                for (int size = ((DataSetObservable) this).mObservers.size() - 1; size >= 0; size--) {
                    DataSetObserver dataSetObserver = (DataSetObserver) ((DataSetObservable) this).mObservers.get(size);
                    if (dataSetObserver instanceof ListDataSetListener) {
                        ((ListDataSetListener) dataSetObserver).onRowDeleted(i3, i16);
                    } else {
                        dataSetObserver.onChanged();
                    }
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void notifyRowInserted(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            synchronized (((DataSetObservable) this).mObservers) {
                for (int size = ((DataSetObservable) this).mObservers.size() - 1; size >= 0; size--) {
                    DataSetObserver dataSetObserver = (DataSetObserver) ((DataSetObservable) this).mObservers.get(size);
                    if (dataSetObserver instanceof ListDataSetListener) {
                        ((ListDataSetListener) dataSetObserver).onRowInserted(i3, i16);
                    } else {
                        dataSetObserver.onChanged();
                    }
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void notifyRowUpdated(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            for (int size = ((DataSetObservable) this).mObservers.size() - 1; size >= 0; size--) {
                DataSetObserver dataSetObserver = (DataSetObserver) ((DataSetObservable) this).mObservers.get(size);
                if (dataSetObserver instanceof ListDataSetListener) {
                    ((ListDataSetListener) dataSetObserver).onRowUpdated(i3, i16);
                } else {
                    dataSetObserver.onChanged();
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void notifyRowDeleted(int... iArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) iArr);
                return;
            }
            synchronized (((DataSetObservable) this).mObservers) {
                for (int size = ((DataSetObservable) this).mObservers.size() - 1; size >= 0; size--) {
                    DataSetObserver dataSetObserver = (DataSetObserver) ((DataSetObservable) this).mObservers.get(size);
                    if (dataSetObserver instanceof ListDataSetListener) {
                        ((ListDataSetListener) dataSetObserver).onRowDeleted(iArr);
                    } else {
                        dataSetObserver.onChanged();
                    }
                }
            }
        }
    }
}
