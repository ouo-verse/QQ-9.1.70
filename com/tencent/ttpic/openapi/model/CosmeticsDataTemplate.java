package com.tencent.ttpic.openapi.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class CosmeticsDataTemplate {
    public static final int PARAM_ATTACH = 3;
    public static final int PARAM_COLOR = 0;
    public static final int PARAM_ENUM = 2;
    public static final int PARAM_IMAGE = 1;
    public static final int PARAM_PALACE = 4;
    public String respath = null;
    public String folder = null;
    public ArrayList<CosmeticsParam> cosmetic_param = null;
    public final Map<String, ArrayList<CosmeticsParam>> eyebrowAttach = new HashMap();

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class CosmeticsParam {
        public int index = 0;
        public String resname = null;
        public String resname2 = null;
        public int red = 0;
        public int green = 0;
        public int blue = 0;
        public int red2 = 0;
        public int green2 = 0;
        public int blue2 = 0;
        public int blend = 0;
        public int blend2 = -1;
        public String cosEnum = null;
        public int paramtype = 0;
        public String enumId = null;
        public int enumAlpha = -1;
        public int enumAlpha2 = -1;
        public int enumRssWidth = 0;
        public String relicsUrl = "";
        public String relicsIcon = "";
        public String portraitIcon = "";
        public ArrayList<Integer> cosparam = null;
        public ArrayList<Integer> cosIndex = null;
    }
}
