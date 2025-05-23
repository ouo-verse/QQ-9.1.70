package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProGuildSearchRsp extends Serializable {
    ArrayList<String> getHighlightWords();

    IGProUnionResult getUnionResult();

    String toString();
}
