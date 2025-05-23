package com.tencent.ttpic.videoshelf.model.edit;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;

/* compiled from: P */
/* loaded from: classes27.dex */
public class NodeItem {
    public Bitmap bitmap;
    public String coverURL;
    public Bitmap cropBitmap;
    public int[] indexLayerForPag;
    public int nodeGroupID;
    public int nodeID;
    public int nodeTextMaxCount;
    public int zIndex;
    public RectF maskRect = new RectF();
    public int type = 0;
    public boolean once = true;
    public Matrix matrix = new Matrix();
    public NodeText nodeTextGroup = new NodeText();
}
