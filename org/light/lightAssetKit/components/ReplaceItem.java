package org.light.lightAssetKit.components;

import org.light.lightAssetKit.enums.BackgroundFillMode;
import org.light.lightAssetKit.enums.ReplaceType;
import org.light.lightAssetKit.enums.ScaleMode;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ReplaceItem {
    public int index = -1;
    public String src = "";
    public ReplaceType replaceType = ReplaceType.None;
    public int sourceIndex = -1;
    public int textMaxLength = 0;
    public ScaleMode scaleMode = ScaleMode.LetterBox;
    public BackgroundFillMode backgroundFillMode = BackgroundFillMode.FillModeNone;
    public String backgroundColor = "#000000ff";
    public boolean interactive = false;
    public TextReplaceItem textReplaceItem = new TextReplaceItem();
    public String layerName = "";
    public boolean needTTS = false;
}
