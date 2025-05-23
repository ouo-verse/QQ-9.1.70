package com.tencent.biz.qqcircle.immersive.search.viewmodel;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSPicFeedPlayEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSVideoFeedPlayEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.qcircle.api.event.QCircleKeyVolumeChangeEvent;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import u60.c;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSearchViewModel extends BaseViewModel implements LifecycleObserver, SimpleEventReceiver {
    public int D;

    /* renamed from: m, reason: collision with root package name */
    public boolean f89998m;

    /* renamed from: i, reason: collision with root package name */
    private final MutableLiveData<Boolean> f89997i = new MutableLiveData<>(Boolean.TRUE);
    private boolean C = true;
    public c E = new c();

    public QFSSearchViewModel() {
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    public String L1() {
        int i3 = this.D;
        if (i3 != 0) {
            if (i3 != 1) {
                return QCircleDaTongConstant.PageId.PG_XSJ_SEARCH_RESULT_PAGE;
            }
            return QCircleDaTongConstant.PageId.PG_XSJ_SEARCH_CONNECTIVE_PAGE;
        }
        return QCircleDaTongConstant.PageId.PG_XSJ_SEARCH_PAGE;
    }

    public MutableLiveData<Boolean> M1() {
        return this.f89997i;
    }

    public boolean N1() {
        return Boolean.TRUE.equals(this.f89997i.getValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void O1(Context context) {
        int hashCode;
        if (context == 0) {
            hashCode = 0;
        } else {
            hashCode = context.hashCode();
        }
        this.contextHashCode = hashCode;
        if (context instanceof LifecycleOwner) {
            ((LifecycleOwner) context).getLifecycle().addObserver(this);
        }
    }

    public void P1(boolean z16) {
        this.f89997i.setValue(Boolean.valueOf(z16));
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<?>> getEventClass() {
        ArrayList<Class<?>> arrayList = new ArrayList<>();
        arrayList.add(QFSVideoFeedPlayEvent.class);
        arrayList.add(QFSPicFeedPlayEvent.class);
        arrayList.add(QCircleKeyVolumeChangeEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "QFSSearchViewModel";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        this.C = false;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if ((simpleBaseEvent instanceof QCircleKeyVolumeChangeEvent) && this.C) {
            P1(false);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        this.C = true;
    }
}
