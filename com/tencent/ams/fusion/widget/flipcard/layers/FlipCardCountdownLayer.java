package com.tencent.ams.fusion.widget.flipcard.layers;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.ams.fusion.widget.animatorview.animator.KeepAnimator;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.BitmapLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.GroupLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.TextLayer;
import com.tencent.ams.fusion.widget.flipcard.FlipCardAnimationHelper;
import com.tencent.ams.fusion.widget.flipcard.FlipCardInfo;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class FlipCardCountdownLayer extends GroupLayer {
    static IPatchRedirector $redirector_;
    private static int colonHeight;
    private static int colonWidth;
    private static int itemPadding;
    private static int itemWidth;
    private final FlipCardInfo mCardInfo;
    private Bitmap mColonBitmap;
    private TextLayer mDaysLayer;
    private ItemLayer[] mItemLayers;
    private Bitmap mNumberBgBitmap;
    private final Bitmap[] mNumberBitmaps;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class ItemLayer extends GroupLayer {
        static IPatchRedirector $redirector_;
        private BitmapLayer mNumberLayer;

        public ItemLayer(Context context, float f16, float f17, int i3, int i16, FlipCardInfo flipCardInfo) {
            super(new AnimatorLayer[0]);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, FlipCardCountdownLayer.this, context, Float.valueOf(f16), Float.valueOf(f17), Integer.valueOf(i3), Integer.valueOf(i16), flipCardInfo);
                return;
            }
            setX(f16);
            setY(f17);
            setWidth(i3);
            setHeight(i16);
            addLayer(createBackgroundLayer());
            BitmapLayer createNumberLayer = createNumberLayer(context, flipCardInfo);
            this.mNumberLayer = createNumberLayer;
            addLayer(createNumberLayer);
        }

        private AnimatorLayer createBackgroundLayer() {
            FlipCardBitmapLayer flipCardBitmapLayer = new FlipCardBitmapLayer();
            flipCardBitmapLayer.setBitmap(FlipCardCountdownLayer.this.mNumberBgBitmap);
            flipCardBitmapLayer.setWidth(getWidth());
            flipCardBitmapLayer.setHeight(getHeight());
            flipCardBitmapLayer.setAnimator(new KeepAnimator(flipCardBitmapLayer));
            return flipCardBitmapLayer;
        }

        private BitmapLayer createNumberLayer(Context context, FlipCardInfo flipCardInfo) {
            FlipCardBitmapLayer flipCardBitmapLayer = new FlipCardBitmapLayer();
            int relativeSize375 = Utils.getRelativeSize375(context, 26);
            flipCardBitmapLayer.setBitmap(Utils.bitmapFromBase64StringSafe(FlipCardAnimationHelper.NUMBERS[0], getWidth(), relativeSize375));
            flipCardBitmapLayer.setTintColor(FlipCardAnimationHelper.getThemeColor(flipCardInfo));
            flipCardBitmapLayer.setWidth(getWidth());
            flipCardBitmapLayer.setHeight(relativeSize375);
            flipCardBitmapLayer.setX(0.0f);
            flipCardBitmapLayer.setY((getHeight() - relativeSize375) / 2.0f);
            flipCardBitmapLayer.setAnimator(new KeepAnimator(flipCardBitmapLayer));
            return flipCardBitmapLayer;
        }

        public void setNumber(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            } else if (i3 >= 0 && i3 <= 9) {
                this.mNumberLayer.setBitmap(FlipCardCountdownLayer.this.mNumberBitmaps[i3]);
            }
        }
    }

    public FlipCardCountdownLayer(Context context, float f16, float f17, int i3, FlipCardInfo flipCardInfo, boolean z16) {
        super(new AnimatorLayer[0]);
        float f18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, Float.valueOf(f16), Float.valueOf(f17), Integer.valueOf(i3), flipCardInfo, Boolean.valueOf(z16));
            return;
        }
        this.mNumberBitmaps = new Bitmap[10];
        this.mItemLayers = new ItemLayer[6];
        this.mCardInfo = flipCardInfo;
        setX(f16);
        setY(f17);
        setHeight(i3);
        initNumberBitmaps(context);
        itemWidth = Utils.getRelativeSize375(context, 24);
        itemPadding = Utils.getRelativeSize375(context, 3);
        colonWidth = Utils.getRelativeSize375(context, 2);
        colonHeight = Utils.getRelativeSize375(context, 8);
        initColonBitmap();
        initBgBitmap(z16);
        long[] lifeTime = flipCardInfo.getLifeTime();
        if (lifeTime != null && lifeTime.length == 4 && lifeTime[0] != 0) {
            TextLayer createDaysLayer = createDaysLayer(context);
            this.mDaysLayer = createDaysLayer;
            addLayer(createDaysLayer);
        }
        ItemLayer[] itemLayerArr = this.mItemLayers;
        if (this.mDaysLayer == null) {
            f18 = 0.0f;
        } else {
            f18 = itemWidth;
        }
        itemLayerArr[0] = createItemLayer(context, f18);
        addLayer(this.mItemLayers[0]);
        ItemLayer[] itemLayerArr2 = this.mItemLayers;
        itemLayerArr2[1] = createItemLayer(context, itemLayerArr2[0].getX() + itemWidth + itemPadding);
        addLayer(this.mItemLayers[1]);
        AnimatorLayer createColonLayer = createColonLayer(this.mItemLayers[1].getX() + itemWidth + itemPadding);
        addLayer(createColonLayer);
        this.mItemLayers[2] = createItemLayer(context, createColonLayer.getX() + colonWidth + itemPadding);
        addLayer(this.mItemLayers[2]);
        ItemLayer[] itemLayerArr3 = this.mItemLayers;
        itemLayerArr3[3] = createItemLayer(context, itemLayerArr3[2].getX() + itemWidth + itemPadding);
        addLayer(this.mItemLayers[3]);
        AnimatorLayer createColonLayer2 = createColonLayer(this.mItemLayers[3].getX() + itemWidth + itemPadding);
        addLayer(createColonLayer2);
        this.mItemLayers[4] = createItemLayer(context, createColonLayer2.getX() + colonWidth + itemPadding);
        addLayer(this.mItemLayers[4]);
        ItemLayer[] itemLayerArr4 = this.mItemLayers;
        itemLayerArr4[5] = createItemLayer(context, itemLayerArr4[4].getX() + itemWidth + itemPadding);
        addLayer(this.mItemLayers[5]);
        updateTime(lifeTime);
    }

    private AnimatorLayer createColonLayer(float f16) {
        FlipCardBitmapLayer flipCardBitmapLayer = new FlipCardBitmapLayer();
        flipCardBitmapLayer.setBitmap(this.mColonBitmap);
        flipCardBitmapLayer.setTintColor(FlipCardAnimationHelper.getThemeColor(this.mCardInfo));
        flipCardBitmapLayer.setWidth(colonWidth);
        flipCardBitmapLayer.setHeight(colonHeight);
        flipCardBitmapLayer.setX(f16);
        flipCardBitmapLayer.setY((getHeight() - colonHeight) / 2.0f);
        flipCardBitmapLayer.setAnimator(new KeepAnimator(flipCardBitmapLayer));
        return flipCardBitmapLayer;
    }

    private TextLayer createDaysLayer(Context context) {
        TextLayer textLayer = new TextLayer();
        textLayer.setX(0.0f);
        int relativeSize375 = Utils.getRelativeSize375(context, 10);
        textLayer.setY(((getHeight() - relativeSize375) / 2.0f) + Utils.getRelativeSize375(context, 8));
        textLayer.setTextBold(true);
        textLayer.setTextSize(relativeSize375);
        textLayer.setTextColor(FlipCardAnimationHelper.getThemeColor(this.mCardInfo));
        return textLayer;
    }

    private ItemLayer createItemLayer(Context context, float f16) {
        return new ItemLayer(context, f16, 0.0f, itemWidth, getHeight(), this.mCardInfo);
    }

    private void initBgBitmap(boolean z16) {
        String str;
        if (z16) {
            str = FlipCardAnimationHelper.NUMBER_BG_WHITE;
        } else {
            str = FlipCardAnimationHelper.NUMBER_BG_GRAY;
        }
        this.mNumberBgBitmap = Utils.bitmapFromBase64StringSafe(str, itemWidth, getHeight());
    }

    private void initColonBitmap() {
        this.mColonBitmap = Utils.bitmapFromBase64StringSafe(FlipCardAnimationHelper.COLON, colonWidth, colonHeight);
    }

    private void initNumberBitmaps(Context context) {
        int relativeSize375 = Utils.getRelativeSize375(context, 24);
        int relativeSize3752 = Utils.getRelativeSize375(context, 26);
        for (int i3 = 0; i3 < 10; i3++) {
            this.mNumberBitmaps[i3] = Utils.bitmapFromBase64StringSafe(FlipCardAnimationHelper.NUMBERS[i3], relativeSize375, relativeSize3752);
        }
    }

    private void updateItemTime(ItemLayer itemLayer, ItemLayer itemLayer2, int i3) {
        if (i3 < 100 && i3 >= 0) {
            if (i3 < 10) {
                itemLayer.setNumber(0);
                itemLayer2.setNumber(i3);
                return;
            } else {
                itemLayer.setNumber(i3 / 10);
                itemLayer2.setNumber(i3 % 10);
                return;
            }
        }
        itemLayer.setNumber(0);
        itemLayer2.setNumber(0);
    }

    public void updateTime(long[] jArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) jArr);
            return;
        }
        if (jArr != null && jArr.length == 4) {
            TextLayer textLayer = this.mDaysLayer;
            if (textLayer != null) {
                textLayer.setText(jArr[0] + "\u5929");
            }
            ItemLayer[] itemLayerArr = this.mItemLayers;
            updateItemTime(itemLayerArr[0], itemLayerArr[1], (int) jArr[1]);
            ItemLayer[] itemLayerArr2 = this.mItemLayers;
            updateItemTime(itemLayerArr2[2], itemLayerArr2[3], (int) jArr[2]);
            ItemLayer[] itemLayerArr3 = this.mItemLayers;
            updateItemTime(itemLayerArr3[4], itemLayerArr3[5], (int) jArr[3]);
            return;
        }
        TextLayer textLayer2 = this.mDaysLayer;
        if (textLayer2 != null) {
            textLayer2.setText("0\u5929");
        }
        ItemLayer[] itemLayerArr4 = this.mItemLayers;
        updateItemTime(itemLayerArr4[0], itemLayerArr4[1], 0);
        ItemLayer[] itemLayerArr5 = this.mItemLayers;
        updateItemTime(itemLayerArr5[2], itemLayerArr5[3], 0);
        ItemLayer[] itemLayerArr6 = this.mItemLayers;
        updateItemTime(itemLayerArr6[4], itemLayerArr6[5], 0);
    }
}
