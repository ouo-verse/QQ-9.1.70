package com.tencent.mobileqq.qqguildsdk.tianjige;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u001a\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0001\u001a\u00020\u0000\"<\u0010\u000b\u001a*\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\bj\u0014\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002`\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\n\"0\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00060\bj\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0006`\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\n\"0\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r0\bj\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r`\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/tianjige/GuildHistogramScene;", "scene", "", "", "a", "(Lcom/tencent/mobileqq/qqguildsdk/tianjige/GuildHistogramScene;)[Ljava/lang/Double;", "Lcom/tencent/mobileqq/qqguildsdk/tianjige/GuildPublicSampleRate;", "b", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "histogramBucketMap", "histogramPublicReportType", "Lcom/tencent/mobileqq/qqguildsdk/tianjige/GuildGraySampleRate;", "c", "histogramGrayReportType", "qqguild-sdk-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final HashMap<GuildHistogramScene, Double[]> f268498a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final HashMap<GuildHistogramScene, GuildPublicSampleRate> f268499b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final HashMap<GuildHistogramScene, GuildGraySampleRate> f268500c;

    static {
        HashMap<GuildHistogramScene, Double[]> hashMap = new HashMap<>();
        GuildHistogramScene guildHistogramScene = GuildHistogramScene.GUILD_AIO_OPEN_DURATION;
        Double valueOf = Double.valueOf(100.0d);
        hashMap.put(guildHistogramScene, new Double[]{Double.valueOf(5.0d), Double.valueOf(10.0d), Double.valueOf(25.0d), Double.valueOf(50.0d), Double.valueOf(75.0d), valueOf, Double.valueOf(250.0d), Double.valueOf(500.0d), Double.valueOf(750.0d), Double.valueOf(1000.0d), Double.valueOf(2500.0d), Double.valueOf(5000.0d), Double.valueOf(7500.0d), Double.valueOf(10000.0d)});
        GuildHistogramScene guildHistogramScene2 = GuildHistogramScene.GUILD_LIVE_PLAY_BLOCK_RATE;
        hashMap.put(guildHistogramScene2, new Double[]{Double.valueOf(1.0d), Double.valueOf(2.0d), Double.valueOf(3.0d), Double.valueOf(4.0d), Double.valueOf(5.0d), Double.valueOf(6.0d), Double.valueOf(7.0d), Double.valueOf(8.0d), Double.valueOf(9.0d), Double.valueOf(10.0d), Double.valueOf(11.0d), Double.valueOf(12.0d), Double.valueOf(13.0d), Double.valueOf(14.0d), Double.valueOf(15.0d), Double.valueOf(16.0d), Double.valueOf(17.0d), Double.valueOf(18.0d), Double.valueOf(19.0d), Double.valueOf(20.0d), Double.valueOf(21.0d), Double.valueOf(22.0d), Double.valueOf(23.0d), Double.valueOf(24.0d), Double.valueOf(25.0d), Double.valueOf(26.0d), Double.valueOf(27.0d), Double.valueOf(28.0d), Double.valueOf(29.0d), Double.valueOf(30.0d), Double.valueOf(31.0d), Double.valueOf(32.0d), Double.valueOf(33.0d), Double.valueOf(34.0d), Double.valueOf(35.0d), Double.valueOf(36.0d), Double.valueOf(37.0d), Double.valueOf(38.0d), Double.valueOf(39.0d), Double.valueOf(40.0d), Double.valueOf(45.0d), Double.valueOf(50.0d), Double.valueOf(60.0d), Double.valueOf(70.0d), Double.valueOf(80.0d), Double.valueOf(90.0d), valueOf});
        GuildHistogramScene guildHistogramScene3 = GuildHistogramScene.GUILD_MINI_APP_LOAD_DURATION;
        hashMap.put(guildHistogramScene3, new Double[]{Double.valueOf(10.0d), Double.valueOf(20.0d), Double.valueOf(30.0d), Double.valueOf(40.0d), Double.valueOf(50.0d), Double.valueOf(60.0d), Double.valueOf(70.0d), Double.valueOf(80.0d), Double.valueOf(90.0d), valueOf, Double.valueOf(110.0d), Double.valueOf(120.0d), Double.valueOf(150.0d), Double.valueOf(180.0d), Double.valueOf(210.0d), Double.valueOf(240.0d), Double.valueOf(270.0d), Double.valueOf(300.0d), Double.valueOf(330.0d), Double.valueOf(360.0d), Double.valueOf(390.0d), Double.valueOf(420.0d), Double.valueOf(480.0d), Double.valueOf(540.0d), Double.valueOf(600.0d), Double.valueOf(660.0d), Double.valueOf(720.0d), Double.valueOf(780.0d), Double.valueOf(840.0d), Double.valueOf(900.0d), Double.valueOf(960.0d), Double.valueOf(1020.0d), Double.valueOf(1140.0d), Double.valueOf(1260.0d), Double.valueOf(1380.0d), Double.valueOf(1500.0d), Double.valueOf(1620.0d), Double.valueOf(1860.0d), Double.valueOf(2000.0d), Double.valueOf(2500.0d), Double.valueOf(3000.0d), Double.valueOf(3500.0d), Double.valueOf(4000.0d), Double.valueOf(4800.0d), Double.valueOf(5600.0d)});
        Double[] dArr = {valueOf, Double.valueOf(200.0d), Double.valueOf(300.0d), Double.valueOf(320.0d), Double.valueOf(340.0d), Double.valueOf(360.0d), Double.valueOf(380.0d), Double.valueOf(400.0d), Double.valueOf(420.0d), Double.valueOf(440.0d), Double.valueOf(460.0d), Double.valueOf(480.0d), Double.valueOf(500.0d), Double.valueOf(520.0d), Double.valueOf(540.0d), Double.valueOf(560.0d), Double.valueOf(580.0d), Double.valueOf(600.0d), Double.valueOf(620.0d), Double.valueOf(640.0d), Double.valueOf(660.0d), Double.valueOf(680.0d), Double.valueOf(700.0d), Double.valueOf(720.0d), Double.valueOf(740.0d), Double.valueOf(760.0d), Double.valueOf(780.0d), Double.valueOf(800.0d), Double.valueOf(820.0d), Double.valueOf(840.0d), Double.valueOf(860.0d), Double.valueOf(880.0d), Double.valueOf(900.0d), Double.valueOf(920.0d), Double.valueOf(940.0d), Double.valueOf(960.0d), Double.valueOf(980.0d), Double.valueOf(1000.0d), Double.valueOf(1020.0d), Double.valueOf(1040.0d), Double.valueOf(1060.0d), Double.valueOf(1080.0d), Double.valueOf(1100.0d), Double.valueOf(1120.0d), Double.valueOf(1140.0d), Double.valueOf(1160.0d), Double.valueOf(1180.0d), Double.valueOf(1200.0d), Double.valueOf(1220.0d), Double.valueOf(1240.0d), Double.valueOf(1260.0d), Double.valueOf(1280.0d), Double.valueOf(1300.0d), Double.valueOf(1320.0d), Double.valueOf(1340.0d), Double.valueOf(1360.0d), Double.valueOf(1380.0d), Double.valueOf(1400.0d), Double.valueOf(1420.0d), Double.valueOf(1440.0d), Double.valueOf(1460.0d), Double.valueOf(1480.0d), Double.valueOf(1500.0d), Double.valueOf(1520.0d), Double.valueOf(1540.0d), Double.valueOf(1560.0d), Double.valueOf(1580.0d), Double.valueOf(1600.0d), Double.valueOf(1620.0d), Double.valueOf(1640.0d), Double.valueOf(1660.0d), Double.valueOf(1680.0d), Double.valueOf(1700.0d), Double.valueOf(1720.0d), Double.valueOf(1740.0d), Double.valueOf(1760.0d), Double.valueOf(1780.0d), Double.valueOf(1800.0d), Double.valueOf(1820.0d), Double.valueOf(1840.0d), Double.valueOf(1860.0d), Double.valueOf(1880.0d), Double.valueOf(1900.0d), Double.valueOf(1920.0d), Double.valueOf(1940.0d), Double.valueOf(1960.0d), Double.valueOf(1980.0d), Double.valueOf(2000.0d), Double.valueOf(2020.0d), Double.valueOf(2040.0d), Double.valueOf(2060.0d), Double.valueOf(2080.0d), Double.valueOf(2100.0d), Double.valueOf(2120.0d), Double.valueOf(2140.0d), Double.valueOf(2160.0d), Double.valueOf(2180.0d), Double.valueOf(2200.0d), Double.valueOf(2220.0d), Double.valueOf(2240.0d), Double.valueOf(2260.0d), Double.valueOf(2280.0d), Double.valueOf(2300.0d), Double.valueOf(2320.0d), Double.valueOf(2340.0d), Double.valueOf(2360.0d), Double.valueOf(2380.0d), Double.valueOf(2400.0d), Double.valueOf(2420.0d), Double.valueOf(2440.0d), Double.valueOf(2460.0d), Double.valueOf(2480.0d), Double.valueOf(2500.0d), Double.valueOf(2520.0d), Double.valueOf(2540.0d), Double.valueOf(2560.0d), Double.valueOf(2580.0d), Double.valueOf(2600.0d), Double.valueOf(2620.0d), Double.valueOf(2640.0d), Double.valueOf(2660.0d), Double.valueOf(2680.0d), Double.valueOf(2700.0d), Double.valueOf(2720.0d), Double.valueOf(2740.0d), Double.valueOf(2760.0d), Double.valueOf(2780.0d), Double.valueOf(2800.0d), Double.valueOf(2820.0d), Double.valueOf(2840.0d), Double.valueOf(2860.0d), Double.valueOf(2880.0d), Double.valueOf(2900.0d), Double.valueOf(2920.0d), Double.valueOf(2940.0d), Double.valueOf(2960.0d), Double.valueOf(2980.0d), Double.valueOf(3000.0d), Double.valueOf(3020.0d), Double.valueOf(3040.0d), Double.valueOf(3060.0d), Double.valueOf(3080.0d), Double.valueOf(3100.0d), Double.valueOf(3120.0d), Double.valueOf(3140.0d), Double.valueOf(3160.0d), Double.valueOf(3180.0d), Double.valueOf(3200.0d), Double.valueOf(3220.0d), Double.valueOf(3240.0d), Double.valueOf(3260.0d), Double.valueOf(3280.0d), Double.valueOf(3300.0d), Double.valueOf(3320.0d), Double.valueOf(3340.0d), Double.valueOf(3360.0d), Double.valueOf(3380.0d), Double.valueOf(3400.0d), Double.valueOf(3420.0d), Double.valueOf(3440.0d), Double.valueOf(3460.0d), Double.valueOf(3480.0d), Double.valueOf(3500.0d), Double.valueOf(3520.0d), Double.valueOf(3540.0d), Double.valueOf(3560.0d), Double.valueOf(3580.0d), Double.valueOf(3600.0d), Double.valueOf(3620.0d), Double.valueOf(3640.0d), Double.valueOf(3660.0d), Double.valueOf(3680.0d), Double.valueOf(3700.0d), Double.valueOf(3720.0d), Double.valueOf(3740.0d), Double.valueOf(3760.0d), Double.valueOf(3780.0d), Double.valueOf(3800.0d), Double.valueOf(3820.0d), Double.valueOf(3840.0d), Double.valueOf(3860.0d), Double.valueOf(3880.0d), Double.valueOf(3900.0d), Double.valueOf(3920.0d), Double.valueOf(3940.0d), Double.valueOf(3960.0d), Double.valueOf(3980.0d), Double.valueOf(4000.0d), Double.valueOf(4020.0d), Double.valueOf(4040.0d), Double.valueOf(4060.0d), Double.valueOf(4080.0d), Double.valueOf(4100.0d), Double.valueOf(4120.0d), Double.valueOf(4140.0d), Double.valueOf(4160.0d), Double.valueOf(4180.0d), Double.valueOf(4200.0d), Double.valueOf(4220.0d), Double.valueOf(4240.0d), Double.valueOf(4260.0d), Double.valueOf(4280.0d), Double.valueOf(4300.0d), Double.valueOf(4320.0d), Double.valueOf(4340.0d), Double.valueOf(4360.0d), Double.valueOf(4380.0d), Double.valueOf(4400.0d), Double.valueOf(4420.0d), Double.valueOf(4440.0d), Double.valueOf(4460.0d), Double.valueOf(4480.0d), Double.valueOf(4500.0d), Double.valueOf(4520.0d), Double.valueOf(4540.0d), Double.valueOf(4560.0d), Double.valueOf(4580.0d), Double.valueOf(4600.0d), Double.valueOf(4620.0d), Double.valueOf(4640.0d), Double.valueOf(4660.0d), Double.valueOf(4680.0d), Double.valueOf(4700.0d), Double.valueOf(4720.0d), Double.valueOf(4740.0d), Double.valueOf(4760.0d), Double.valueOf(4780.0d), Double.valueOf(4800.0d), Double.valueOf(4820.0d), Double.valueOf(4840.0d), Double.valueOf(4860.0d), Double.valueOf(4880.0d), Double.valueOf(4900.0d), Double.valueOf(4920.0d), Double.valueOf(4940.0d), Double.valueOf(4960.0d), Double.valueOf(4980.0d), Double.valueOf(5000.0d), Double.valueOf(5020.0d), Double.valueOf(5040.0d), Double.valueOf(5060.0d), Double.valueOf(5080.0d), Double.valueOf(5100.0d), Double.valueOf(5120.0d), Double.valueOf(5140.0d), Double.valueOf(5160.0d), Double.valueOf(5180.0d), Double.valueOf(5200.0d), Double.valueOf(5220.0d), Double.valueOf(5240.0d), Double.valueOf(5260.0d), Double.valueOf(5280.0d), Double.valueOf(5300.0d), Double.valueOf(5320.0d), Double.valueOf(5340.0d), Double.valueOf(5360.0d), Double.valueOf(5380.0d), Double.valueOf(5400.0d), Double.valueOf(5420.0d), Double.valueOf(5440.0d), Double.valueOf(5460.0d), Double.valueOf(5480.0d), Double.valueOf(5500.0d), Double.valueOf(5520.0d), Double.valueOf(5540.0d), Double.valueOf(5560.0d), Double.valueOf(5580.0d), Double.valueOf(5600.0d), Double.valueOf(5620.0d), Double.valueOf(5640.0d), Double.valueOf(5660.0d), Double.valueOf(5680.0d), Double.valueOf(5700.0d), Double.valueOf(5720.0d), Double.valueOf(5740.0d), Double.valueOf(5760.0d), Double.valueOf(5780.0d), Double.valueOf(5800.0d), Double.valueOf(5820.0d), Double.valueOf(5840.0d), Double.valueOf(5860.0d), Double.valueOf(5880.0d), Double.valueOf(5900.0d), Double.valueOf(5920.0d), Double.valueOf(5940.0d), Double.valueOf(5960.0d), Double.valueOf(5980.0d), Double.valueOf(6000.0d), Double.valueOf(6050.0d), Double.valueOf(6100.0d), Double.valueOf(6150.0d), Double.valueOf(6200.0d), Double.valueOf(6250.0d), Double.valueOf(6300.0d), Double.valueOf(6350.0d), Double.valueOf(6400.0d), Double.valueOf(6450.0d), Double.valueOf(6500.0d), Double.valueOf(6550.0d), Double.valueOf(6600.0d), Double.valueOf(6650.0d), Double.valueOf(6700.0d), Double.valueOf(6750.0d), Double.valueOf(6800.0d), Double.valueOf(6850.0d), Double.valueOf(6900.0d), Double.valueOf(6950.0d), Double.valueOf(7000.0d), Double.valueOf(7050.0d), Double.valueOf(7100.0d), Double.valueOf(7150.0d), Double.valueOf(7200.0d), Double.valueOf(7250.0d), Double.valueOf(7300.0d), Double.valueOf(7350.0d), Double.valueOf(7400.0d), Double.valueOf(7450.0d), Double.valueOf(7500.0d), Double.valueOf(7550.0d), Double.valueOf(7600.0d), Double.valueOf(7650.0d), Double.valueOf(7700.0d), Double.valueOf(7750.0d), Double.valueOf(7800.0d), Double.valueOf(7850.0d), Double.valueOf(7900.0d), Double.valueOf(7950.0d), Double.valueOf(8000.0d), Double.valueOf(8100.0d), Double.valueOf(8200.0d), Double.valueOf(8300.0d), Double.valueOf(8400.0d), Double.valueOf(8500.0d), Double.valueOf(8600.0d), Double.valueOf(8700.0d), Double.valueOf(8800.0d), Double.valueOf(8900.0d), Double.valueOf(9000.0d), Double.valueOf(9100.0d), Double.valueOf(9200.0d), Double.valueOf(9300.0d), Double.valueOf(9400.0d), Double.valueOf(9500.0d), Double.valueOf(9600.0d), Double.valueOf(9700.0d), Double.valueOf(9800.0d), Double.valueOf(9900.0d), Double.valueOf(10000.0d), Double.valueOf(20000.0d)};
        GuildHistogramScene guildHistogramScene4 = GuildHistogramScene.GUILD_START_UP_DIRECTLY_TIME_COST;
        hashMap.put(guildHistogramScene4, dArr);
        GuildHistogramScene guildHistogramScene5 = GuildHistogramScene.GUILD_START_UP_MSG2GUILD_TIME_COST;
        hashMap.put(guildHistogramScene5, dArr);
        hashMap.put(GuildHistogramScene.GUILD_PUBLIC_ACCOUNT_INIT_TIME_COST, new Double[]{valueOf, Double.valueOf(200.0d), Double.valueOf(300.0d), Double.valueOf(320.0d), Double.valueOf(340.0d), Double.valueOf(360.0d), Double.valueOf(380.0d), Double.valueOf(400.0d), Double.valueOf(420.0d), Double.valueOf(440.0d), Double.valueOf(460.0d), Double.valueOf(480.0d), Double.valueOf(500.0d), Double.valueOf(520.0d), Double.valueOf(540.0d), Double.valueOf(560.0d), Double.valueOf(580.0d), Double.valueOf(600.0d), Double.valueOf(620.0d), Double.valueOf(640.0d), Double.valueOf(660.0d), Double.valueOf(680.0d), Double.valueOf(700.0d), Double.valueOf(720.0d), Double.valueOf(740.0d), Double.valueOf(760.0d), Double.valueOf(780.0d), Double.valueOf(800.0d), Double.valueOf(820.0d), Double.valueOf(840.0d), Double.valueOf(860.0d), Double.valueOf(880.0d), Double.valueOf(900.0d), Double.valueOf(920.0d), Double.valueOf(940.0d), Double.valueOf(960.0d), Double.valueOf(980.0d), Double.valueOf(1000.0d), Double.valueOf(1020.0d), Double.valueOf(1040.0d), Double.valueOf(1060.0d), Double.valueOf(1080.0d), Double.valueOf(1100.0d), Double.valueOf(1120.0d), Double.valueOf(1140.0d), Double.valueOf(1160.0d), Double.valueOf(1180.0d), Double.valueOf(1200.0d), Double.valueOf(1220.0d), Double.valueOf(1240.0d), Double.valueOf(1260.0d), Double.valueOf(1280.0d), Double.valueOf(1300.0d), Double.valueOf(1320.0d), Double.valueOf(1340.0d), Double.valueOf(1360.0d), Double.valueOf(1380.0d), Double.valueOf(1400.0d), Double.valueOf(1420.0d), Double.valueOf(1440.0d), Double.valueOf(1460.0d), Double.valueOf(1480.0d), Double.valueOf(1500.0d), Double.valueOf(1520.0d), Double.valueOf(1540.0d), Double.valueOf(1560.0d), Double.valueOf(1580.0d), Double.valueOf(1600.0d), Double.valueOf(1620.0d), Double.valueOf(1640.0d), Double.valueOf(1660.0d), Double.valueOf(1680.0d), Double.valueOf(1700.0d), Double.valueOf(1720.0d), Double.valueOf(1740.0d), Double.valueOf(1760.0d), Double.valueOf(1780.0d), Double.valueOf(1800.0d), Double.valueOf(1820.0d), Double.valueOf(1840.0d), Double.valueOf(1860.0d), Double.valueOf(1880.0d), Double.valueOf(1900.0d), Double.valueOf(1920.0d), Double.valueOf(1940.0d), Double.valueOf(1960.0d), Double.valueOf(1980.0d), Double.valueOf(2000.0d), Double.valueOf(2020.0d), Double.valueOf(2040.0d), Double.valueOf(2060.0d), Double.valueOf(2080.0d), Double.valueOf(2100.0d), Double.valueOf(2120.0d), Double.valueOf(2140.0d), Double.valueOf(2160.0d), Double.valueOf(2180.0d), Double.valueOf(2200.0d), Double.valueOf(2220.0d), Double.valueOf(2240.0d), Double.valueOf(2260.0d), Double.valueOf(2280.0d), Double.valueOf(2300.0d), Double.valueOf(2320.0d), Double.valueOf(2340.0d), Double.valueOf(2360.0d), Double.valueOf(2380.0d), Double.valueOf(2400.0d), Double.valueOf(2420.0d), Double.valueOf(2440.0d), Double.valueOf(2460.0d), Double.valueOf(2480.0d), Double.valueOf(2500.0d), Double.valueOf(2550.0d), Double.valueOf(2600.0d), Double.valueOf(2650.0d), Double.valueOf(2700.0d), Double.valueOf(2750.0d), Double.valueOf(2800.0d), Double.valueOf(2850.0d), Double.valueOf(2900.0d), Double.valueOf(2950.0d), Double.valueOf(3000.0d), Double.valueOf(3100.0d), Double.valueOf(3150.0d), Double.valueOf(3200.0d), Double.valueOf(3250.0d), Double.valueOf(3300.0d), Double.valueOf(3350.0d), Double.valueOf(3400.0d), Double.valueOf(3450.0d), Double.valueOf(3500.0d), Double.valueOf(3550.0d), Double.valueOf(3600.0d), Double.valueOf(3650.0d), Double.valueOf(3700.0d), Double.valueOf(3750.0d), Double.valueOf(3800.0d), Double.valueOf(3850.0d), Double.valueOf(3900.0d), Double.valueOf(3950.0d), Double.valueOf(4000.0d), Double.valueOf(5000.0d), Double.valueOf(6000.0d), Double.valueOf(7000.0d), Double.valueOf(8000.0d), Double.valueOf(9000.0d), Double.valueOf(10000.0d)});
        Double[] dArr2 = {Double.valueOf(1.0d), Double.valueOf(5.0d), Double.valueOf(10.0d), Double.valueOf(20.0d), Double.valueOf(30.0d), Double.valueOf(40.0d), Double.valueOf(50.0d), Double.valueOf(60.0d), Double.valueOf(70.0d), Double.valueOf(80.0d), Double.valueOf(90.0d), valueOf, Double.valueOf(110.0d), Double.valueOf(120.0d), Double.valueOf(140.0d), Double.valueOf(160.0d), Double.valueOf(180.0d), Double.valueOf(200.0d), Double.valueOf(220.0d), Double.valueOf(240.0d), Double.valueOf(260.0d), Double.valueOf(280.0d), Double.valueOf(300.0d), Double.valueOf(320.0d), Double.valueOf(340.0d), Double.valueOf(360.0d), Double.valueOf(380.0d), Double.valueOf(400.0d), Double.valueOf(420.0d), Double.valueOf(440.0d), Double.valueOf(460.0d), Double.valueOf(480.0d), Double.valueOf(520.0d), Double.valueOf(560.0d), Double.valueOf(600.0d), Double.valueOf(640.0d), Double.valueOf(680.0d), Double.valueOf(720.0d), Double.valueOf(760.0d), Double.valueOf(800.0d), Double.valueOf(840.0d), Double.valueOf(880.0d), Double.valueOf(920.0d), Double.valueOf(960.0d), Double.valueOf(1000.0d), Double.valueOf(1040.0d), Double.valueOf(1080.0d), Double.valueOf(1140.0d), Double.valueOf(1200.0d), Double.valueOf(1260.0d), Double.valueOf(1320.0d), Double.valueOf(1380.0d), Double.valueOf(1440.0d), Double.valueOf(1500.0d), Double.valueOf(1560.0d), Double.valueOf(1620.0d), Double.valueOf(1680.0d), Double.valueOf(1740.0d), Double.valueOf(1800.0d), Double.valueOf(1860.0d), Double.valueOf(1920.0d), Double.valueOf(1980.0d), Double.valueOf(2200.0d), Double.valueOf(2400.0d), Double.valueOf(2600.0d), Double.valueOf(2800.0d), Double.valueOf(3000.0d), Double.valueOf(3200.0d), Double.valueOf(3600.0d), Double.valueOf(3800.0d), Double.valueOf(4000.0d), Double.valueOf(4300.0d), Double.valueOf(4600.0d), Double.valueOf(4900.0d), Double.valueOf(5200.0d), Double.valueOf(5500.0d), Double.valueOf(5800.0d), Double.valueOf(6100.0d), Double.valueOf(6500.0d), Double.valueOf(7000.0d), Double.valueOf(7500.0d), Double.valueOf(8000.0d), Double.valueOf(8500.0d), Double.valueOf(9000.0d), Double.valueOf(9500.0d), Double.valueOf(10000.0d)};
        GuildHistogramScene guildHistogramScene6 = GuildHistogramScene.GUILD_AIO_LOAD_FIRST_PAGE_TIME_COST;
        hashMap.put(guildHistogramScene6, dArr2);
        GuildHistogramScene guildHistogramScene7 = GuildHistogramScene.GUILD_AIO_LOAD_LATEST_DB_MSG_TIME_COST;
        hashMap.put(guildHistogramScene7, dArr2);
        GuildHistogramScene guildHistogramScene8 = GuildHistogramScene.GUILD_AIO_ENTER_TO_ANIM_TIME_COST;
        hashMap.put(guildHistogramScene8, dArr2);
        GuildHistogramScene guildHistogramScene9 = GuildHistogramScene.GUILD_AIO_FIRST_VIEW_TIME_COST;
        hashMap.put(guildHistogramScene9, dArr2);
        Double[] dArr3 = {Double.valueOf(0.01d), Double.valueOf(0.05d), Double.valueOf(0.1d), Double.valueOf(0.2d), Double.valueOf(0.3d), Double.valueOf(0.4d), Double.valueOf(0.5d), Double.valueOf(0.6d), Double.valueOf(0.7d), Double.valueOf(0.8d), Double.valueOf(0.9d), Double.valueOf(1.0d), Double.valueOf(1.2d), Double.valueOf(1.4d), Double.valueOf(1.6d), Double.valueOf(1.8d), Double.valueOf(1.9d), Double.valueOf(2.0d), Double.valueOf(2.2d), Double.valueOf(2.4d), Double.valueOf(2.6d), Double.valueOf(2.8d), Double.valueOf(3.0d), Double.valueOf(3.2d), Double.valueOf(3.4d), Double.valueOf(3.6d), Double.valueOf(3.8d), Double.valueOf(4.0d), Double.valueOf(4.2d), Double.valueOf(4.4d), Double.valueOf(4.6d), Double.valueOf(4.8d), Double.valueOf(5.0d), Double.valueOf(5.2d), Double.valueOf(5.4d), Double.valueOf(5.6d), Double.valueOf(5.8d), Double.valueOf(6.0d), Double.valueOf(6.3d), Double.valueOf(6.6d), Double.valueOf(6.9d), Double.valueOf(7.2d), Double.valueOf(7.5d), Double.valueOf(7.8d), Double.valueOf(8.1d), Double.valueOf(8.4d), Double.valueOf(8.7d), Double.valueOf(9.0d), Double.valueOf(9.4d), Double.valueOf(9.8d), Double.valueOf(10.2d), Double.valueOf(10.6d), Double.valueOf(11.0d), Double.valueOf(11.5d), Double.valueOf(12.0d), Double.valueOf(12.5d), Double.valueOf(13.0d), Double.valueOf(13.5d), Double.valueOf(14.0d), Double.valueOf(14.5d), Double.valueOf(15.0d), Double.valueOf(16.0d), Double.valueOf(17.0d), Double.valueOf(18.0d), Double.valueOf(19.0d), Double.valueOf(20.0d), Double.valueOf(21.0d), Double.valueOf(22.0d), Double.valueOf(23.0d), Double.valueOf(24.0d), Double.valueOf(25.0d), Double.valueOf(26.0d), Double.valueOf(27.0d), Double.valueOf(28.0d), Double.valueOf(29.0d), Double.valueOf(30.0d), Double.valueOf(40.0d), Double.valueOf(50.0d)};
        GuildHistogramScene guildHistogramScene10 = GuildHistogramScene.GUILD_AIO_BIND_COMPONENT_TIME_COST;
        hashMap.put(guildHistogramScene10, dArr3);
        GuildHistogramScene guildHistogramScene11 = GuildHistogramScene.GUILD_AIO_BIND_INPUT_TIME_COST;
        hashMap.put(guildHistogramScene11, dArr3);
        GuildHistogramScene guildHistogramScene12 = GuildHistogramScene.GUILD_AIO_BIND_TITLE_TIME_COST;
        hashMap.put(guildHistogramScene12, dArr3);
        GuildHistogramScene guildHistogramScene13 = GuildHistogramScene.GUILD_AIO_MSG_PRE_PARSE_TIME_COST;
        hashMap.put(guildHistogramScene13, dArr3);
        Double[] dArr4 = {Double.valueOf(10.0d), Double.valueOf(20.0d), Double.valueOf(30.0d), Double.valueOf(40.0d), Double.valueOf(50.0d), Double.valueOf(60.0d), Double.valueOf(70.0d), Double.valueOf(80.0d), Double.valueOf(90.0d), valueOf, Double.valueOf(110.0d), Double.valueOf(120.0d), Double.valueOf(130.0d), Double.valueOf(140.0d), Double.valueOf(150.0d), Double.valueOf(160.0d), Double.valueOf(170.0d), Double.valueOf(180.0d), Double.valueOf(190.0d), Double.valueOf(200.0d), Double.valueOf(240.0d), Double.valueOf(280.0d), Double.valueOf(320.0d), Double.valueOf(360.0d), Double.valueOf(400.0d), Double.valueOf(450.0d), Double.valueOf(500.0d), Double.valueOf(550.0d), Double.valueOf(600.0d), Double.valueOf(650.0d), Double.valueOf(700.0d), Double.valueOf(750.0d), Double.valueOf(800.0d), Double.valueOf(850.0d), Double.valueOf(900.0d), Double.valueOf(950.0d), Double.valueOf(1000.0d), Double.valueOf(1500.0d), Double.valueOf(2000.0d), Double.valueOf(2500.0d), Double.valueOf(3000.0d), Double.valueOf(3500.0d), Double.valueOf(4000.0d), Double.valueOf(4500.0d), Double.valueOf(5000.0d), Double.valueOf(10000.0d)};
        GuildHistogramScene guildHistogramScene14 = GuildHistogramScene.GUILD_FEED_ENTER_MY_FEEDS_TIME_COST;
        hashMap.put(guildHistogramScene14, dArr4);
        GuildHistogramScene guildHistogramScene15 = GuildHistogramScene.GUILD_FEED_ENTER_FEEDS_SQUARE_TIME_COST;
        hashMap.put(guildHistogramScene15, dArr4);
        Double[] dArr5 = {Double.valueOf(1.0d), Double.valueOf(3.0d), Double.valueOf(5.0d), Double.valueOf(7.0d), Double.valueOf(9.0d), Double.valueOf(11.0d), Double.valueOf(13.0d), Double.valueOf(15.0d), Double.valueOf(17.0d), Double.valueOf(19.0d), Double.valueOf(21.0d), Double.valueOf(23.0d), Double.valueOf(25.0d), Double.valueOf(27.0d), Double.valueOf(29.0d), Double.valueOf(35.0d), Double.valueOf(40.0d), Double.valueOf(60.0d), valueOf, Double.valueOf(200.0d), Double.valueOf(500.0d)};
        GuildHistogramScene guildHistogramScene16 = GuildHistogramScene.MKD_DRAW_TIME;
        hashMap.put(guildHistogramScene16, dArr5);
        GuildHistogramScene guildHistogramScene17 = GuildHistogramScene.MKD_MEASURE_TIME;
        hashMap.put(guildHistogramScene17, dArr5);
        GuildHistogramScene guildHistogramScene18 = GuildHistogramScene.MKD_LAYOUT_TIME;
        hashMap.put(guildHistogramScene18, dArr5);
        GuildHistogramScene guildHistogramScene19 = GuildHistogramScene.MKD_PARSE_TIME;
        hashMap.put(guildHistogramScene19, dArr5);
        GuildHistogramScene guildHistogramScene20 = GuildHistogramScene.MKD_CODE_PARSE_TIME;
        hashMap.put(guildHistogramScene20, dArr5);
        GuildHistogramScene guildHistogramScene21 = GuildHistogramScene.MKD_CODE_MEASURE_TIME;
        hashMap.put(guildHistogramScene21, dArr5);
        GuildHistogramScene guildHistogramScene22 = GuildHistogramScene.MKD_CODE_DRAW_TIME;
        hashMap.put(guildHistogramScene22, dArr5);
        f268498a = hashMap;
        HashMap<GuildHistogramScene, GuildPublicSampleRate> hashMap2 = new HashMap<>();
        hashMap2.put(guildHistogramScene2, GuildPublicSampleRate.PUBLIC_FULL);
        GuildPublicSampleRate guildPublicSampleRate = GuildPublicSampleRate.PUBLIC_MANAGE;
        hashMap2.put(guildHistogramScene4, guildPublicSampleRate);
        hashMap2.put(guildHistogramScene5, guildPublicSampleRate);
        GuildHistogramScene guildHistogramScene23 = GuildHistogramScene.GUILD_CHANGE_TIME_COST;
        hashMap2.put(guildHistogramScene23, guildPublicSampleRate);
        GuildHistogramScene guildHistogramScene24 = GuildHistogramScene.GUILD_DIRECT_MSG_LIST_TIME_COST;
        hashMap2.put(guildHistogramScene24, guildPublicSampleRate);
        GuildHistogramScene guildHistogramScene25 = GuildHistogramScene.GUILD_MEMBER_LIST_TIME_COST;
        hashMap2.put(guildHistogramScene25, guildPublicSampleRate);
        GuildHistogramScene guildHistogramScene26 = GuildHistogramScene.GUILD_NOTICE_COST;
        hashMap2.put(guildHistogramScene26, guildPublicSampleRate);
        GuildHistogramScene guildHistogramScene27 = GuildHistogramScene.GUILD_ASSISTANT_COST;
        hashMap2.put(guildHistogramScene27, guildPublicSampleRate);
        GuildHistogramScene guildHistogramScene28 = GuildHistogramScene.GUILD_MEMBER_SELECT_TIME_COST;
        hashMap2.put(guildHistogramScene28, guildPublicSampleRate);
        hashMap2.put(guildHistogramScene3, guildPublicSampleRate);
        GuildHistogramScene guildHistogramScene29 = GuildHistogramScene.GUILD_FACADE_FRAGMENT_ON_CREATE_VIEW_DURATION;
        hashMap2.put(guildHistogramScene29, guildPublicSampleRate);
        GuildPublicSampleRate guildPublicSampleRate2 = GuildPublicSampleRate.PUBLIC_NONE;
        hashMap2.put(guildHistogramScene6, guildPublicSampleRate2);
        hashMap2.put(guildHistogramScene7, guildPublicSampleRate2);
        hashMap2.put(guildHistogramScene8, guildPublicSampleRate2);
        hashMap2.put(guildHistogramScene9, guildPublicSampleRate2);
        hashMap2.put(guildHistogramScene10, guildPublicSampleRate2);
        hashMap2.put(guildHistogramScene11, guildPublicSampleRate2);
        hashMap2.put(guildHistogramScene12, guildPublicSampleRate2);
        hashMap2.put(guildHistogramScene13, guildPublicSampleRate2);
        hashMap2.put(guildHistogramScene14, guildPublicSampleRate2);
        hashMap2.put(guildHistogramScene15, guildPublicSampleRate2);
        GuildHistogramScene guildHistogramScene30 = GuildHistogramScene.MEDIA_GUILD_PULL_WEB_VIEW;
        hashMap2.put(guildHistogramScene30, guildPublicSampleRate);
        GuildHistogramScene guildHistogramScene31 = GuildHistogramScene.MEDIA_GUILD_GET_AUTH_CODE;
        hashMap2.put(guildHistogramScene31, guildPublicSampleRate);
        GuildHistogramScene guildHistogramScene32 = GuildHistogramScene.MEDIA_GUILD_WEB_VIEW_FINISH;
        hashMap2.put(guildHistogramScene32, guildPublicSampleRate);
        GuildHistogramScene guildHistogramScene33 = GuildHistogramScene.MEDIA_GUILD_WEB_RENDER_START;
        hashMap2.put(guildHistogramScene33, guildPublicSampleRate);
        GuildHistogramScene guildHistogramScene34 = GuildHistogramScene.MEDIA_GUILD_WEB_RENDER_COMPLETE;
        hashMap2.put(guildHistogramScene34, guildPublicSampleRate);
        GuildHistogramScene guildHistogramScene35 = GuildHistogramScene.MEDIA_GUILD_SHOW_AUTH_PANEL;
        hashMap2.put(guildHistogramScene35, guildPublicSampleRate);
        GuildHistogramScene guildHistogramScene36 = GuildHistogramScene.MEDIA_GUILD_WEB_USE_OFFLINE;
        hashMap2.put(guildHistogramScene36, guildPublicSampleRate);
        hashMap2.put(guildHistogramScene16, guildPublicSampleRate);
        hashMap2.put(guildHistogramScene17, guildPublicSampleRate);
        hashMap2.put(guildHistogramScene18, guildPublicSampleRate);
        hashMap2.put(guildHistogramScene19, guildPublicSampleRate);
        hashMap2.put(guildHistogramScene20, guildPublicSampleRate);
        hashMap2.put(guildHistogramScene21, guildPublicSampleRate);
        hashMap2.put(guildHistogramScene22, guildPublicSampleRate);
        f268499b = hashMap2;
        HashMap<GuildHistogramScene, GuildGraySampleRate> hashMap3 = new HashMap<>();
        hashMap3.put(guildHistogramScene, GuildGraySampleRate.GRAY_MANAGE);
        GuildGraySampleRate guildGraySampleRate = GuildGraySampleRate.GRAY_FULL;
        hashMap3.put(guildHistogramScene2, guildGraySampleRate);
        hashMap3.put(guildHistogramScene4, guildGraySampleRate);
        hashMap3.put(guildHistogramScene5, guildGraySampleRate);
        hashMap3.put(guildHistogramScene23, guildGraySampleRate);
        hashMap3.put(guildHistogramScene24, guildGraySampleRate);
        hashMap3.put(guildHistogramScene25, guildGraySampleRate);
        hashMap3.put(guildHistogramScene26, guildGraySampleRate);
        hashMap3.put(guildHistogramScene27, guildGraySampleRate);
        hashMap3.put(guildHistogramScene28, guildGraySampleRate);
        hashMap3.put(GuildHistogramScene.GUILD_NT_SERVICE_CALL_DURATION, guildGraySampleRate);
        hashMap3.put(GuildHistogramScene.GUILD_NT_ORM_CALL_DURATION, guildGraySampleRate);
        hashMap3.put(GuildHistogramScene.GUILD_NT_INIT_DURATION, guildGraySampleRate);
        hashMap3.put(GuildHistogramScene.GUILD_LOAD_GUILD_LIST_DURATION, guildGraySampleRate);
        hashMap3.put(guildHistogramScene3, guildGraySampleRate);
        hashMap3.put(guildHistogramScene29, guildGraySampleRate);
        hashMap3.put(guildHistogramScene6, guildGraySampleRate);
        hashMap3.put(guildHistogramScene7, guildGraySampleRate);
        hashMap3.put(guildHistogramScene8, guildGraySampleRate);
        hashMap3.put(guildHistogramScene9, guildGraySampleRate);
        hashMap3.put(guildHistogramScene10, guildGraySampleRate);
        hashMap3.put(guildHistogramScene11, guildGraySampleRate);
        hashMap3.put(guildHistogramScene12, guildGraySampleRate);
        hashMap3.put(guildHistogramScene13, guildGraySampleRate);
        hashMap3.put(guildHistogramScene14, guildGraySampleRate);
        hashMap3.put(guildHistogramScene15, guildGraySampleRate);
        hashMap3.put(guildHistogramScene30, guildGraySampleRate);
        hashMap3.put(guildHistogramScene31, guildGraySampleRate);
        hashMap3.put(guildHistogramScene32, guildGraySampleRate);
        hashMap3.put(guildHistogramScene33, guildGraySampleRate);
        hashMap3.put(guildHistogramScene34, guildGraySampleRate);
        hashMap3.put(guildHistogramScene35, guildGraySampleRate);
        hashMap3.put(guildHistogramScene36, guildGraySampleRate);
        hashMap3.put(guildHistogramScene16, guildGraySampleRate);
        hashMap3.put(guildHistogramScene17, guildGraySampleRate);
        hashMap3.put(guildHistogramScene18, guildGraySampleRate);
        hashMap3.put(guildHistogramScene19, guildGraySampleRate);
        hashMap3.put(guildHistogramScene20, guildGraySampleRate);
        hashMap3.put(guildHistogramScene21, guildGraySampleRate);
        hashMap3.put(guildHistogramScene22, guildGraySampleRate);
        f268500c = hashMap3;
    }

    @Nullable
    public static final Double[] a(@NotNull GuildHistogramScene scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        return f268498a.get(scene);
    }

    @Nullable
    public static final GuildPublicSampleRate b(@NotNull GuildHistogramScene scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        return f268499b.get(scene);
    }
}
