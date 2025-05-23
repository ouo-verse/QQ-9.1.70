package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProMVPRichText;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProMVPRichTextContent;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProMVPRichText implements IGProMVPRichText {
    public final GProMVPRichText mInfo;

    public GGProMVPRichText(GProMVPRichText gProMVPRichText) {
        this.mInfo = gProMVPRichText;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPRichText
    public ArrayList<IGProMVPRichTextContent> getContents() {
        ArrayList<GProMVPRichTextContent> contents = this.mInfo.getContents();
        ArrayList<IGProMVPRichTextContent> arrayList = new ArrayList<>();
        Iterator<GProMVPRichTextContent> it = contents.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProMVPRichTextContent(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPRichText
    public String toString() {
        return this.mInfo.toString();
    }
}
