package com.tencent.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.CursorFilter;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class XCursorAdapter extends XBaseAdapter implements Filterable, CursorFilter.CursorFilterClient {
    static IPatchRedirector $redirector_ = null;

    @Deprecated
    public static final int FLAG_AUTO_REQUERY = 1;
    public static final int FLAG_REGISTER_CONTENT_OBSERVER = 2;
    protected boolean mAutoRequery;
    protected ChangeObserver mChangeObserver;
    protected Context mContext;
    protected Cursor mCursor;
    protected CursorFilter mCursorFilter;
    protected DataSetObserver mDataSetObserver;
    protected boolean mDataValid;
    protected FilterQueryProvider mFilterQueryProvider;
    protected int mRowIDColumn;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class ChangeObserver extends ContentObserver {
        static IPatchRedirector $redirector_;

        public ChangeObserver() {
            super(new Handler());
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) XCursorAdapter.this);
            }
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
            } else {
                XCursorAdapter.this.onContentChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class MyDataSetObserver extends DataSetObserver {
        static IPatchRedirector $redirector_;

        MyDataSetObserver() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) XCursorAdapter.this);
            }
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            XCursorAdapter xCursorAdapter = XCursorAdapter.this;
            xCursorAdapter.mDataValid = true;
            xCursorAdapter.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            XCursorAdapter xCursorAdapter = XCursorAdapter.this;
            xCursorAdapter.mDataValid = false;
            xCursorAdapter.notifyDataSetInvalidated();
        }
    }

    @Deprecated
    public XCursorAdapter(Context context, Cursor cursor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            init(context, cursor, 1);
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) cursor);
        }
    }

    public abstract void bindView(View view, Context context, Cursor cursor);

    @Override // com.tencent.widget.CursorFilter.CursorFilterClient
    public void changeCursor(Cursor cursor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) cursor);
            return;
        }
        Cursor swapCursor = swapCursor(cursor);
        if (swapCursor != null) {
            swapCursor.close();
        }
    }

    @Override // com.tencent.widget.CursorFilter.CursorFilterClient
    public CharSequence convertToString(Cursor cursor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (CharSequence) iPatchRedirector.redirect((short) 15, (Object) this, (Object) cursor);
        }
        if (cursor == null) {
            return "";
        }
        return cursor.toString();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        if (this.mDataValid && (cursor = this.mCursor) != null) {
            return cursor.getCount();
        }
        return 0;
    }

    @Override // com.tencent.widget.CursorFilter.CursorFilterClient
    public Cursor getCursor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Cursor) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mCursor;
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i3, View view, ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (View) iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), view, viewGroup);
        }
        if (this.mDataValid) {
            this.mCursor.moveToPosition(i3);
            if (view == null) {
                view = newDropDownView(this.mContext, this.mCursor, viewGroup);
            }
            bindView(view, this.mContext, this.mCursor);
            return view;
        }
        return null;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (Filter) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        if (this.mCursorFilter == null) {
            this.mCursorFilter = new CursorFilter(this);
        }
        return this.mCursorFilter;
    }

    public FilterQueryProvider getFilterQueryProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (FilterQueryProvider) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.mFilterQueryProvider;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        Cursor cursor;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return iPatchRedirector.redirect((short) 7, (Object) this, i3);
        }
        if (this.mDataValid && (cursor = this.mCursor) != null) {
            cursor.moveToPosition(i3);
            return this.mCursor;
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        Cursor cursor;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Long) iPatchRedirector.redirect((short) 8, (Object) this, i3)).longValue();
        }
        if (!this.mDataValid || (cursor = this.mCursor) == null || !cursor.moveToPosition(i3)) {
            return 0L;
        }
        return this.mCursor.getLong(this.mRowIDColumn);
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View view2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            view2 = (View) iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), view, viewGroup);
        } else if (this.mDataValid) {
            if (this.mCursor.moveToPosition(i3)) {
                if (view == null) {
                    view2 = newView(this.mContext, this.mCursor, viewGroup);
                } else {
                    view2 = view;
                }
                bindView(view2, this.mContext, this.mCursor);
            } else {
                throw new IllegalStateException("couldn't move cursor to position " + i3);
            }
        } else {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return true;
    }

    @Deprecated
    protected void init(Context context, Cursor cursor, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            init(context, cursor, z16 ? 1 : 2);
        } else {
            iPatchRedirector.redirect((short) 4, this, context, cursor, Boolean.valueOf(z16));
        }
    }

    public View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (View) iPatchRedirector.redirect((short) 12, this, context, cursor, viewGroup);
        }
        return newView(context, cursor, viewGroup);
    }

    public abstract View newView(Context context, Cursor cursor, ViewGroup viewGroup);

    protected void onContentChanged() {
        Cursor cursor;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        } else if (this.mAutoRequery && (cursor = this.mCursor) != null && !cursor.isClosed()) {
            this.mDataValid = this.mCursor.requery();
        }
    }

    @Override // com.tencent.widget.CursorFilter.CursorFilterClient
    public Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (Cursor) iPatchRedirector.redirect((short) 16, (Object) this, (Object) charSequence);
        }
        FilterQueryProvider filterQueryProvider = this.mFilterQueryProvider;
        if (filterQueryProvider != null) {
            return filterQueryProvider.runQuery(charSequence);
        }
        return this.mCursor;
    }

    public void setFilterQueryProvider(FilterQueryProvider filterQueryProvider) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) filterQueryProvider);
        } else {
            this.mFilterQueryProvider = filterQueryProvider;
        }
    }

    public Cursor swapCursor(Cursor cursor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Cursor) iPatchRedirector.redirect((short) 14, (Object) this, (Object) cursor);
        }
        Cursor cursor2 = this.mCursor;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            ChangeObserver changeObserver = this.mChangeObserver;
            if (changeObserver != null) {
                cursor2.unregisterContentObserver(changeObserver);
            }
            DataSetObserver dataSetObserver = this.mDataSetObserver;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.mCursor = cursor;
        if (cursor != null) {
            ChangeObserver changeObserver2 = this.mChangeObserver;
            if (changeObserver2 != null) {
                cursor.registerContentObserver(changeObserver2);
            }
            DataSetObserver dataSetObserver2 = this.mDataSetObserver;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.mRowIDColumn = cursor.getColumnIndexOrThrow("_id");
            this.mDataValid = true;
            notifyDataSetChanged();
        } else {
            this.mRowIDColumn = -1;
            this.mDataValid = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }

    void init(Context context, Cursor cursor, int i3) {
        if ((i3 & 1) == 1) {
            i3 |= 2;
            this.mAutoRequery = true;
        } else {
            this.mAutoRequery = false;
        }
        boolean z16 = cursor != null;
        this.mCursor = cursor;
        this.mDataValid = z16;
        this.mContext = context;
        this.mRowIDColumn = z16 ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i3 & 2) == 2) {
            this.mChangeObserver = new ChangeObserver();
            this.mDataSetObserver = new MyDataSetObserver();
        } else {
            this.mChangeObserver = null;
            this.mDataSetObserver = null;
        }
        if (z16) {
            ChangeObserver changeObserver = this.mChangeObserver;
            if (changeObserver != null) {
                cursor.registerContentObserver(changeObserver);
            }
            DataSetObserver dataSetObserver = this.mDataSetObserver;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public XCursorAdapter(Context context, Cursor cursor, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            init(context, cursor, z16 ? 1 : 2);
        } else {
            iPatchRedirector.redirect((short) 2, this, context, cursor, Boolean.valueOf(z16));
        }
    }

    public int changeCursor(Cursor cursor, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this, (Object) cursor, i3)).intValue();
        }
        Cursor cursor2 = this.mCursor;
        if (cursor2 != null && cursor2.moveToFirst() && cursor != null) {
            long j3 = this.mCursor.getLong(0);
            for (int i16 = 0; i16 < cursor.getCount(); i16++) {
                if (cursor.moveToPosition(i16) && cursor.getLong(0) == j3) {
                    Cursor swapCursor = swapCursor(cursor, i16);
                    if (swapCursor != null) {
                        swapCursor.close();
                    }
                    return i16;
                }
            }
        }
        changeCursor(cursor);
        return 0;
    }

    public XCursorAdapter(Context context, Cursor cursor, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            init(context, cursor, i3);
        } else {
            iPatchRedirector.redirect((short) 3, this, context, cursor, Integer.valueOf(i3));
        }
    }

    public Cursor swapCursor(Cursor cursor, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (Cursor) iPatchRedirector.redirect((short) 22, (Object) this, (Object) cursor, i3);
        }
        Cursor cursor2 = this.mCursor;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            ChangeObserver changeObserver = this.mChangeObserver;
            if (changeObserver != null) {
                cursor2.unregisterContentObserver(changeObserver);
            }
            DataSetObserver dataSetObserver = this.mDataSetObserver;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.mCursor = cursor;
        if (cursor != null) {
            ChangeObserver changeObserver2 = this.mChangeObserver;
            if (changeObserver2 != null) {
                cursor.registerContentObserver(changeObserver2);
            }
            DataSetObserver dataSetObserver2 = this.mDataSetObserver;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.mRowIDColumn = cursor.getColumnIndexOrThrow("_id");
            this.mDataValid = true;
            if (i3 > 0) {
                notifyRowInserted(0, i3 - 1);
            }
            notifyDataSetChanged();
        } else {
            this.mRowIDColumn = -1;
            this.mDataValid = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }
}
