package com.qzone.proxy.covercomponent;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.qzone.proxy.covercomponent.adapter.ICoverResources;
import com.qzone.proxy.covercomponent.ui.ICoverBaseView;
import com.qzone.proxy.covercomponent.ui.IQZoneCoverContainer;
import com.tencent.component.media.image.ImageProcessor;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public interface ICoverComponentUI {
    IQZoneCoverContainer getCoverContainerInstance(Context context, ViewGroup viewGroup, long j3, ICoverResources iCoverResources);

    ICoverBaseView getCoverVideoCoverView(Context context, Activity activity, FrameLayout frameLayout, long j3, HashMap<String, String> hashMap, ICoverResources iCoverResources, int i3);

    ImageProcessor getFullScreenCoverImageProcessor(String str);

    ImageProcessor getQzoneShowInnerSquareImageProcess(int i3, double d16);

    ImageProcessor getSquareImageProcessor();
}
