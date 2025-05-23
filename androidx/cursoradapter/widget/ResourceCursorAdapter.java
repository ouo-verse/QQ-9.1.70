package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: P */
/* loaded from: classes.dex */
public abstract class ResourceCursorAdapter extends CursorAdapter {
    private int mDropDownLayout;
    private LayoutInflater mInflater;
    private int mLayout;

    @Deprecated
    public ResourceCursorAdapter(Context context, int i3, Cursor cursor) {
        super(context, cursor);
        this.mDropDownLayout = i3;
        this.mLayout = i3;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.mInflater.inflate(this.mDropDownLayout, viewGroup, false);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.mInflater.inflate(this.mLayout, viewGroup, false);
    }

    public void setDropDownViewResource(int i3) {
        this.mDropDownLayout = i3;
    }

    public void setViewResource(int i3) {
        this.mLayout = i3;
    }

    @Deprecated
    public ResourceCursorAdapter(Context context, int i3, Cursor cursor, boolean z16) {
        super(context, cursor, z16);
        this.mDropDownLayout = i3;
        this.mLayout = i3;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public ResourceCursorAdapter(Context context, int i3, Cursor cursor, int i16) {
        super(context, cursor, i16);
        this.mDropDownLayout = i3;
        this.mLayout = i3;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
    }
}
