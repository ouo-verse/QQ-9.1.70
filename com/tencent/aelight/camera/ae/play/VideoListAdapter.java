package com.tencent.aelight.camera.ae.play;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.armap.map.RoundCorneredFrameLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.videoshelf.model.edit.ShelfNode;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class VideoListAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static final int MIN_CLICK_DELAY_TIME = 200;
    private static final String TAG = "VideoListAdapter";
    private static long lastClickTime;
    private Context context;
    private OnVideoNodeClickedListener listener;
    private double mAspectRatio;
    private String mAssetsPath;
    private HashMap<Integer, Bitmap> mBitmaps;
    private boolean mIsHorizontal;
    private List<ShelfNode> mNodeGroupList;
    private ArrayList<String> mSelectedPhotoList;
    private int mSelectedPosition;
    private int mVideoHeight;
    private int mVideoWidth;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface OnVideoNodeClickedListener {
        void onVideoNodeClick(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView hover;
        public ImageView hover_selected;
        public TextView index;
        public TextView index_selected;
        public RoundCorneredFrameLayout internFrameLayout;
        public FrameLayout outFrameLayout;
        public ImageView thumb;

        public ViewHolder(View view) {
            super(view);
            this.outFrameLayout = (FrameLayout) view.findViewById(R.id.s4a);
            this.internFrameLayout = (RoundCorneredFrameLayout) view.findViewById(R.id.ruy);
            ImageView imageView = (ImageView) view.findViewById(R.id.f163758rv0);
            this.thumb = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.hover = (ImageView) view.findViewById(R.id.rum);
            this.index = (TextView) view.findViewById(R.id.f163759rv1);
            this.hover_selected = (ImageView) view.findViewById(R.id.run);
            this.index_selected = (TextView) view.findViewById(R.id.f163760rv2);
        }

        public void autoClick() {
            this.itemView.performClick();
        }
    }

    public VideoListAdapter(Context context, List<ShelfNode> list) {
        this.mAssetsPath = "";
        this.mSelectedPosition = 0;
        this.mBitmaps = new HashMap<>();
        this.mIsHorizontal = false;
        this.mAspectRatio = 0.0d;
        this.context = context;
        this.mNodeGroupList = list;
    }

    public static boolean isFastClick() {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z16 = currentTimeMillis - lastClickTime >= 200;
        lastClickTime = currentTimeMillis;
        return z16;
    }

    public void clearBitmaps() {
        Iterator<Integer> it = this.mBitmaps.keySet().iterator();
        while (it.hasNext()) {
            Bitmap bitmap = this.mBitmaps.get(Integer.valueOf(it.next().intValue()));
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mNodeGroupList.size();
    }

    public void setMaterialPath(String str) {
        this.mAssetsPath = str;
    }

    public void setOnVideoNodeClickedListener(OnVideoNodeClickedListener onVideoNodeClickedListener) {
        this.listener = onVideoNodeClickedListener;
    }

    public void setThumbBackground(int i3, Bitmap bitmap) {
        if (!this.mBitmaps.containsKey(Integer.valueOf(i3))) {
            if (BitmapUtils.isLegal(bitmap)) {
                this.mBitmaps.put(Integer.valueOf(i3), bitmap);
                return;
            }
            return;
        }
        Bitmap bitmap2 = this.mBitmaps.get(Integer.valueOf(i3));
        if (BitmapUtils.isLegal(bitmap)) {
            this.mBitmaps.put(Integer.valueOf(i3), bitmap);
            if (!BitmapUtils.isLegal(bitmap2) || bitmap2 == bitmap) {
                return;
            }
            bitmap2.recycle();
        }
    }

    public void updateThumbBackground() {
        notifyDataSetChanged();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, final int i3) {
        ShelfNode shelfNode = this.mNodeGroupList.get(i3);
        if (shelfNode == null) {
            Log.e(TAG, "onBindViewHolder contain null data item");
            return;
        }
        if (!this.mBitmaps.containsKey(Integer.valueOf(i3))) {
            this.mBitmaps.put(Integer.valueOf(i3), BitmapUtils.decodeSampleBitmap(this.context, this.mAssetsPath + File.separator + shelfNode.getCoverUri(), 1));
        }
        viewHolder.thumb.setImageBitmap(this.mBitmaps.get(Integer.valueOf(i3)));
        String str = "0" + (i3 + 1);
        viewHolder.index.setText(str);
        viewHolder.index_selected.setText(str);
        if (this.mSelectedPosition == i3) {
            viewHolder.hover.setVisibility(8);
            viewHolder.hover_selected.setVisibility(0);
            viewHolder.index.setVisibility(8);
            viewHolder.index_selected.setVisibility(0);
        } else {
            viewHolder.hover.setVisibility(0);
            viewHolder.hover_selected.setVisibility(8);
            viewHolder.index.setVisibility(0);
            viewHolder.index_selected.setVisibility(8);
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.aelight.camera.ae.play.VideoListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                if (VideoListAdapter.isFastClick()) {
                    VideoListAdapter.this.mSelectedPosition = i3;
                    VideoListAdapter.this.notifyDataSetChanged();
                    if (VideoListAdapter.this.listener != null) {
                        VideoListAdapter.this.listener.onVideoNodeClick(i3);
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        return new ViewHolder(LayoutInflater.from(this.context).inflate(R.layout.dlz, viewGroup, false));
    }

    public VideoListAdapter(Context context, List<ShelfNode> list, int i3, int i16) {
        this.mAssetsPath = "";
        this.mSelectedPosition = 0;
        this.mBitmaps = new HashMap<>();
        this.mIsHorizontal = false;
        this.mAspectRatio = 0.0d;
        this.context = context;
        this.mNodeGroupList = list;
        this.mVideoWidth = i3;
        this.mVideoHeight = i16;
        if (i16 != 0) {
            double d16 = i3 / i16;
            this.mAspectRatio = d16;
            this.mIsHorizontal = d16 >= 1.0d;
        }
    }
}
