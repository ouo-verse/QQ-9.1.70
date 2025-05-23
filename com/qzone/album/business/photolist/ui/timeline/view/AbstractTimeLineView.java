package com.qzone.album.business.photolist.ui.timeline.view;

import NS_MOBILE_PHOTO.TabTimeLine;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.qzone.album.business.photolist.ui.timeline.a;
import com.qzone.album.data.model.PhotoPoiArea;
import com.qzone.album.data.model.TimeLine;
import java.util.ArrayList;
import n4.c;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class AbstractTimeLineView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    protected a f43743d;

    /* renamed from: e, reason: collision with root package name */
    protected n4.a f43744e;

    public AbstractTimeLineView(Context context) {
        super(context);
    }

    public n4.a a() {
        if (this.f43744e == null) {
            this.f43744e = new c();
        }
        return this.f43744e;
    }

    public void setTimeLineListener(a aVar) {
        this.f43743d = aVar;
    }

    public AbstractTimeLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AbstractTimeLineView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    public void b() {
    }

    public void setIsAscOrder(boolean z16) {
    }

    public void setRecentPhotoData(ArrayList<TabTimeLine> arrayList) {
    }

    public void setSelection(long j3) {
    }

    public void setLoverAndParentingData(ArrayList<TimeLine> arrayList, long j3) {
    }

    public void setNormalData(ArrayList<TimeLine> arrayList, boolean z16) {
    }

    public void setTravelData(ArrayList<PhotoPoiArea> arrayList, long j3) {
    }
}
